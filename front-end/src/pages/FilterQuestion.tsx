

import { useEffect, useState } from 'react';
import { Table } from 'react-bootstrap';
import { Outlet } from 'react-router-dom';
import { config } from '../Constant';
import configHeader from '../services/ConfigHeader';
import { FaBeer } from 'react-icons/fa';
import { AiOutlineSafetyCertificate } from "react-icons/ai";
import { parse } from 'path';
import axios from 'axios';

// FIXME adicionar um botão de "search" pra mostrar só as certificadas/não certificadas
// FIXME ajustar para celular, tá esquisito

interface ListQuestion {
    idQuestion: number;
    question: string[];
    difficulty: number;
    answers: string[];
    idDiscipline: number;
    idSubject: number;
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



const FiltroDisciplinas = () => {
    const [stateDiscipline, setStateDiscipline] = useState('');
    const [stateSubject, setStateSubject] = useState('');
    const [stateNameDiscipline, setStateNameDiscipline] = useState<ListDiscipline[]>([]);
    const [stateNameSubject, setStateNameSubject] = useState<ListSubject[]>([]);
    const [listQuestions, setListQuestions] = useState<ListQuestion[]>([]);

    const Test = () => {
        const dataRB = {
            "idDiscipline": parseInt(stateDiscipline),
            "idSubject": parseInt(stateSubject),
            "numberOfQuestions": Math.random() *10,
        }

        axios.post(`${config.url.BASE_URL}/tests`, dataRB, configHeader)
            .then(response => setListQuestions(response.data.questions))
            .catch(error => console.error(error));
    }
/**
    useEffect(() => {
        Test();
    }, [stateDiscipline, stateSubject]);

 */
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

    console.log(listQuestions[0])

    //console.log("stateNameDiscipline"+stateNameDiscipline);


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
                onChange={(e) => { setStateSubject(e.target.value) }}
            >
                <option selected>Assunto</option>
                {stateNameSubject.map((op, index) => (
                    <option key={index} value={op.idSubject}>
                        {op.description}
                    </option>
                ))}
            </select>

            <button onClick={Test}>Filtrar</button>
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
                            <hr />
                        </div>
                    </div>


                </>
            ))}



            <Outlet />
        </div>
    );
};

export default FiltroDisciplinas;

/**           <div className="row text-center">
                <p className="h2">Questions</p>
            </div>

            {listQuestions.map((question, index) => (
                <>
                    <div className="row" key={question.id}>
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
                                        <input type="radio" name={`question-${question.id}`} value={answer} />
                                    </div>
                                    <div className="col-sm-auto">
                                        <label>{`${answer}`}</label>
                                    </div>
                                </div>
                            ))}
                            <hr />
                        </div>
                    </div>


                </>
            ))} */
