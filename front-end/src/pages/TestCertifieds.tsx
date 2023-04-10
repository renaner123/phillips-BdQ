import { useEffect, useState } from 'react';
import { Outlet } from 'react-router-dom';
import { config } from '../Constant';
import configHeader from '../services/ConfigHeader';
import axios from 'axios';

interface TestCertifieds {
  idQuestion: number;
  question: string;
  difficulty: number;
  answers: string[];
  idDiscipline: number;
  idSubject: number;
  certified: boolean;
}


const TestCertifiedsTable = () => {
  const [testQuestions, setTestQuestions] = useState<TestCertifieds[]>([]);

  const approveQuestion = (questionId: number, certified: string) => {
    axios
      .put(`${config.url.BASE_URL}/questions/certified/${questionId}?certified=${certified}`, {
        headers: {
          'Content-Type': 'application/json',
          // FIXME passar o state.username e state.password
          Authorization: `Basic ${btoa(`${'certificador@gmail.com'}:${'12345678'}`)}`,
        }
      })
      .then((response) => {
        // remove da tela se for aprovada/reprovada
        setTestQuestions(testQuestions.filter((question) => question.idQuestion !== questionId));
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    axios
      .get(`${config.url.BASE_URL}/questions/certifieds?certified=NULL`, {
        headers: {
          'Content-Type': 'application/json',
           // FIXME passar o state.username e state.password
          Authorization: `Basic ${btoa(`${'certificador@gmail.com'}:${'12345678'}`)}`,
        },
      })
      .then((response) => {
        setTestQuestions(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div className="container">
      <div className="row text-center">
        <p className="h2">Questions</p>
      </div>
      {/* // TODO estilizar esse trecho, talvez alterar os radios por buttons. Deixar parecido com o do qconcursos */}
      {testQuestions.map((question, index) => (
        <div className="row" key={question.idQuestion}>
          <div className="col-sm-auto">
            <p className="h4">{`${index + 1}. ${question.question}`}</p>
          </div>
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
            {/* // FIXME estilizar, não deu tempo */}
            <button onClick={() => approveQuestion(question.idQuestion,"true")}>Aprovar</button>
            <button onClick={() => approveQuestion(question.idQuestion,"false")}>Reprovar</button>
            <hr />
          </div>
        </div>
      ))}
      <Outlet />
    </div>
  );
};

export default TestCertifiedsTable;
