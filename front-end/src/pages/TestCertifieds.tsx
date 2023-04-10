import { useContext, useEffect, useState } from 'react';
import { Outlet } from 'react-router-dom';
import { AuthContext } from '../context/authContext';
import { useAPI } from '../services/Api';

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
  const api = useAPI()
  const auth = useContext(AuthContext);

  useEffect(() => {
    api.get('/questions/certifieds?certified=NULL', {}).then((res) => {
      setTestQuestions(res);
    })
  }, [])

  const approveQuestion = (questionId: number, certified: string) => {
    api.put(`/questions/certified/${questionId}?certified=${certified}`, {}).then((res) => {
      setTestQuestions(testQuestions.filter((question) => question.idQuestion !== questionId));
    })
  };
  

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
            <button className ="btn btn-success sm btn-sm mx-3"onClick={() => approveQuestion(question.idQuestion,"true")}>Aprovar</button>
            <button className="btn btn-danger sm btn-sm mx-3" onClick={() => approveQuestion(question.idQuestion,"false")}>Reprovar</button>
            <hr />
          </div>
        </div>
      ))}
      <Outlet />
    </div>
  );
};

export default TestCertifiedsTable;
