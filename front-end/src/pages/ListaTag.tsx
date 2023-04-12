
import { useEffect, useState } from 'react';
import { Outlet } from 'react-router-dom';
import { config } from '../Constant';
import configHeader from '../services/ConfigHeader';
import axios from 'axios';
import { useAPI } from '../services/Api';


interface ListQuestion {
    idQuestion: number;
    question: string[];
    difficulty: number;
    answers: string[];
    idDiscipline: number;
    idSubject: number;
    tag: string;
    certified: boolean;
}

interface ListDiscipline {
    idDiscipline: number;
    name: string;
    descrption_discipline: string;
}

interface ListSubject {
    idSubject: number;
    description: string;
    amountAccess: 0;
    idDiscipline: number;
}

interface StudentAnswer {
    [questionId: string]: string[]; // o valor para cada chave (id de questão) é um array de respostas
}

interface StudentAnswers {
    idStudent: number;
    answersHash: StudentAnswer;
}

const ListaTag = () => {
    const [stateDiscipline, setStateDiscipline] = useState('');
    const [stateSubject, setStateSubject] = useState('');
    const [stateNameDiscipline, setStateNameDiscipline] = useState<ListDiscipline[]>([]);
    const [stateNameSubject, setStateNameSubject] = useState<ListSubject[]>([]);
    const [listQuestions, setListQuestions] = useState<ListQuestion[]>([]);
    const [listQuestionsTest, setListQuestionsTest] = useState<ListQuestion[]>([]);
    const [stateTags, setStateTags] = useState(Array(listQuestions.length).fill(""));
    const [stateTag, setStateTag] = useState('');
    const [stateRescueTag, setStateRescueTag] = useState('');
    const [tags, setTags] = useState([]);
    const [stateQuestionID, setStateQuestionID] = useState('');


    const api = useAPI();


    const Test = (stateRescueTag: string) => {
        const dataRB = {
            "idDiscipline": parseInt(stateDiscipline),
            "idSubject": parseInt(stateSubject),
            "numberOfQuestions": Math.random() * 10,
        }

        if (stateRescueTag.length != 0) {
            api.get(`/questions/${stateRescueTag}`, {})
                .then((response) => setListQuestions(response))
                .catch(error => console.error(error));
            
        } else if (parseInt(stateDiscipline) && parseInt(stateSubject)) {
            axios.post(`${config.url.BASE_URL}/tests`, dataRB, configHeader)
                .then(response => setListQuestions(response.data.questions))
                .catch(error => console.error(error));
            
        } else {
            alert("Selecione os parametros faltantes. ");
        }

    }

    const sendTag = (stateQuestionID: number, stateTag: string) => {
        api.put(`/questions/tags/${stateQuestionID}?tag=${stateTag}`, {})
            .then((response) => response.data)
            .catch(error => console.error(error));
        console.log(stateTag);
    };


    useEffect(() => {
        if (stateNameSubject.length === 0) {
            try {
                axios.get(`${config.url.BASE_URL}/subjects`, configHeader).then(response => setStateNameSubject(response.data))

            } catch (error) {
                console.error(error)
            }
        }
    }, [stateNameSubject]);

    useEffect(() => {
        if (stateNameDiscipline.length === 0) {
            try {
                axios.get(`${config.url.BASE_URL}/disciplines`, configHeader).then(response => setStateNameDiscipline(response.data))
            } catch (error) {
                console.error(error);
            }
        }
    }, [stateNameDiscipline]);

    const handleTagChange = (event: React.ChangeEvent<HTMLInputElement>, index: number) => {
        const newTags = [...stateTags];
        newTags[index] = event.target.value;
        setStateTags(newTags);
    };

    const handleRescueTagChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setStateRescueTag(event.target.value);
    }

    return (
        <div className="container">
            <select className="form-select"
                value={stateDiscipline}
                onChange={(e) => { setStateDiscipline(e.target.value) }} >
                <option selected>Disciplina</option>
                {stateNameDiscipline.map((op, index) => (
                    <option key={index} value={op.idDiscipline}>
                        {op.name}
                    </option>
                ))}
            </select>
            <select className="form-select"
                value={stateSubject}
                onChange={(e) => { setStateSubject(e.target.value) }}>
                <option selected>Assunto</option>
                {stateNameSubject.map((op, index) => (
                    <option key={index} value={op.idSubject}>
                        {op.description}
                    </option>
                ))}
            </select>
            <div className="row">
                <div className="col-6"><div className="form-group">
                    <input type="text"
                        className="form-control"
                        id="example-input"
                        placeholder="TAG"
                        value={stateRescueTag}
                        onChange={(event) =>
                            handleRescueTagChange(event)
                        } />
                </div>
                </div>

            </div>

            <button onClick={() => Test(stateRescueTag)}>Filtrar</button>

            <div className="row text-center">
                <p className="h2">Questions</p>
            </div>

            {listQuestions.map((question, index) => (
                <>
                    <div className="row" key={question.idQuestion}>
                        <div className="col-sm-auto">
                            <p className="h4">{`${index + 1}. ${question.question}`}</p>
                        </div>
                        <div className="col-sm-auto">                             </div>
                        <div className="row-sm-6">
                            {question.answers.map((answer, index) => (
                                <div className="row mb-3 mx-4" key={index}>
                                    <div className="col-sm-auto">
                                        <label>{`${String.fromCharCode(65 + index)}`}</label>
                                    </div>
                                    <div className="col-sm-auto">
                                        <input type="radio" name={`question-${question.idQuestion}`} value={answer} />
                                    </div>
                                    <div className="col-sm-auto">
                                        <label>{`${answer}`}</label>
                                    </div>
                                </div>
                            ))}
                            <div className="row g-3 align-items-center" key={index}>
                                <div className="col-auto">
                                    <label className="col-form-label">TAG</label>
                                </div>
                                <div className="col-auto">
                                    <input type="text" key={index}
                                        className="form-control"
                                        name={`tag of question ${question.idQuestion}`}
                                        value={stateTag[index]}
                                        onChange={(event) =>
                                            handleTagChange(event, index)
                                        }
                                    />
                                </div>
                                <div className="col-auto">
                                    <span className="form-text">
                                        Opcional
                                    </span>
                                </div>
                                <div className="col-auto">
                                    <button type="button" key="index" className="btn btn-primary btn-sm"
                                        onClick={() => sendTag(question.idQuestion, stateTags[index])} >
                                        Enviar
                                    </button>
                                </div>
                            </div>
                            <hr />
                        </div>
                    </div>
                </>
            ))}
            <Outlet />
        </div>
    );
};

export default ListaTag;