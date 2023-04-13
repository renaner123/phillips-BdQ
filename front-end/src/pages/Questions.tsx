import { useEffect, useState } from "react";
import { Container, Row } from 'react-bootstrap';
import { config } from "../Constant";
import { useAPI } from "../services/Api";

interface Question {
  question: string;
  difficulty: number;
  answers: string[];
  answersSheet: string[];
  idDiscipline: number;
  idSubject: number;
}

interface Subject {
  idSubject: number;
  idDscipline: number;
  description: string;
  amountAccess: number;
}

interface Discipline {
  idDiscipline: number;
  name: string;
  descrption_Discipline : string;
}
interface Discipline {
  id: number;
  name: string;
}

interface Subject {
  id: number;
  name: string;
}

function App() {
  const [question, setQuestion] = useState<Question>({
    question: "",
    difficulty: 1,
    answers: [""],
    answersSheet: [""],
    idDiscipline: 0,
    idSubject: 0,
  });

  // TODO buscar no banco e mostrar a lista

  const handleQuestionChange = (event: React.ChangeEvent<HTMLTextAreaElement>) => {
    setQuestion((prevQuestion) => ({
      ...prevQuestion,
      question: event.target.value,
    }));
  };

  const handleDifficultyChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setQuestion((prevQuestion) => ({
      ...prevQuestion,
      difficulty: parseInt(event.target.value),
    }));
  };

  const handleAnswerChange = (event: React.ChangeEvent<HTMLInputElement>, index: number) => {
    setQuestion((prevQuestion) => ({
      ...prevQuestion,
      answers: prevQuestion.answers.map((answer, i) =>
        i === index ? event.target.value : answer
      ),
    }));
  };

  const handleAddAnswer = () => {
    if (question.answers.length >= 5) return;
    setQuestion((prevQuestion) => ({
      ...prevQuestion,
      answers: [...prevQuestion.answers, ""],
    }));
  };

  const handleClearAnswers = () => {
    setQuestion((prevQuestion) => ({
      ...prevQuestion,
      answers: [""],
    }));
  };

  const handleDisciplineChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setQuestion((prevQuestion) => ({
      ...prevQuestion,
      idDiscipline: parseInt(event.target.value),
    }));
  };

  const handleSubjectChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setQuestion((prevQuestion) => ({
      ...prevQuestion,
      idSubject: parseInt(event.target.value),
    }));
  };

  // para caso o usuário adicionar uma resposta em branco conseguir validar
  const isValidAnswer = (answer: string) => {
    return answer.trim().length > 0;
  };

  const handleSubmit = async () => {

    // filtra somente se a resposta for válida
    const validAnswers = question.answers.filter((answer) => isValidAnswer(answer));

    if (validAnswers.length < 2) {
      alert("Por favor, adicione pelo menos duas respostas.");
      return;
    }

    if (selectedOptions.length === 0) {
      alert("Adicione o Gabarito.");
      return;
    }

    // FIXME retirar login estático - Exemplo no Arquivo TestCertifieds.tsx
    const response = await fetch(`${config.url.BASE_URL}/questions`, {
      method: "POST",
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Basic ${btoa(`${'renan'}:${'123'}`)}`,
      },
      body: JSON.stringify({
        question: question.question,
        difficulty: question.difficulty === 0 ? question.difficulty+1 : question.difficulty,
        answers: question.answers.filter((answer) => answer !== ""),
        idDiscipline: question.idDiscipline === 0 ? question.idDiscipline+1 : question.idDiscipline,
        idSubject: question.idSubject === 0 ? question.idSubject+1 : question.idSubject,
        answersSheet: selectedOptions.map((num) => num.toString()),
      }),
    });
    const data = await response.json();
    console.log(data);
    alert('Question Uploaded Successfully!');

    toggleOpen()

    setSelectedOptions([])

    setQuestion((prevQuestion) => ({
      ...prevQuestion,
      difficulty: 0,
      idSubject: 0,
      question: "",
      idDiscipline: 0,
      answersSheet: [""],
      answers: [""],
    }));

  };
  
  const [subjects, setSubjects] = useState<Subject[]>([]);
  const [disciplines, setDisciplines] = useState<Discipline[]>([]);

  const api = useAPI();  

  useEffect(() => {
    api.get('/disciplines', {}).then((res: React.SetStateAction<Discipline[]>) => {
      console.log("disciplines: " + res)
      setDisciplines(res);
    })
  }, []);

  useEffect(() => {
    api.get('/subjects', {}).then((res: React.SetStateAction<Subject[]>) => {
      console.log("subjects: " + res)
        setSubjects(res);
    })
  },[]);

  const [isOpen, setIsOpen] = useState(false);
  const [selectedOptions, setSelectedOptions] = useState<number[]>([]);

  const toggleOpen = () => setIsOpen(!isOpen);

  const handleAddGabarito = (option: number) => {
    if (selectedOptions.includes(option)) {
      setSelectedOptions(selectedOptions.filter((o) => o !== option));
    } else {
      setSelectedOptions([...selectedOptions, option]);
    }
  };

  return (

    <Container className="container d-flex justify-content-center">
      <Row className="pt-3 justify-content-center align-center" >
        <p className="h2">Cadastro de Pergunta</p>
        <div className="row-md-6 mb-1 align-self-center">
          <label htmlFor="exampleFormControlTextarea1" className="form-label">
            Pergunta:
            <textarea id="exampleFormControlTextarea1" className="form-control" rows={4} cols={50} name="question" value={question.question} onChange={handleQuestionChange} />
          </label>
        </div>


        <div className="row-md-6 mb-1">
          <label>
            Disciplina:
            <select value={question.idDiscipline} onChange={handleDisciplineChange}>
              {disciplines.map((discipline) => (
                <option key={discipline.idDiscipline} value={discipline.idDiscipline}>
                  {discipline.name}
                </option>
              ))}
            </select>
          </label>
          <br />
        </div>

        <div className="row-md-6 mb-1">
          <label>
            Assunto:
            <select value={question.idSubject} onChange={handleSubjectChange}>
              {subjects.map((subject) => (
                <option key={subject.idSubject} value={subject.idSubject}>
                  {subject.description}
                </option>
              ))}
            </select>
          </label>
        </div>

        <div className="row-md-6 mb-1">
          <label>
            Dificuldade:
            <select value={question.difficulty} onChange={handleDifficultyChange}>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
            </select>
          </label>
        </div>

        <h1>Respostas:</h1>
        <div className="row-md-6 mb-1">
          <label>
            {question.answers.map((answer, index) => (
              <div className="p-1" key={index}>
                <label>
                  Resposta {index + 1}:
                  <input type="text" title={answer} value={answer} onChange={(event) => handleAnswerChange(event, index)} />
                </label>
              </div>
            ))}
          </label>
          <br />
          {question.answers.length < 5 && <button className="btn btn-secondary  me-1 btn-sm" onClick={handleAddAnswer}>Adicionar Resposta</button>}
          <button className="btn btn-secondary btn-sm " onClick={handleClearAnswers}>Limpar Respostas</button>
          <div>
            {question.answers.length >= 5 && <p className=" mt-1 alert alert-warning " role="alert">Máximo de 5 respostas atingido.</p>}
          </div>
        </div>
        <br />

        <div>
          <button className="btn btn-secondary btn-sm" onClick={toggleOpen}>Salvar gabarito</button>
          {isOpen && (
            <div className="row">
              <p className="mb-2 mt-2">Selecione as respostas corretas:</p>
              {(Array.from({ length: question.answers.length }, (_, index) => index + 1)).map((option) => (
                <>

                  <div className="col-sm-auto">
                    <label>
                      {option}
                    </label>
                  </div>

                  <div className="col-sm-auto">
                    <label key={option}>
                      <input className="me-1"
                        type="checkbox"
                        checked={selectedOptions.includes(option)}
                        onChange={() => handleAddGabarito(option)} />
                    </label>
                  </div>

                </>
              ))}
            </div>
          )}
        </div>

        <div>
          <button className="btn btn-primary btn-sm mt-3" onClick={handleSubmit}>Enviar</button>
        </div>




      </Row>
    </Container >
  );
}

export default App;