import { useEffect, useState } from 'react';
import { Table } from 'react-bootstrap';
import { Outlet } from 'react-router-dom';
import { config } from '../Constant';
import configHeader from '../services/ConfigHeader';
import { FaBeer } from 'react-icons/fa';
import { AiOutlineSafetyCertificate } from "react-icons/ai";

// FIXME adicionar um botão de "search" pra mostrar só as certificadas/não certificadas
// FIXME ajustar para celular, tá esquisito

interface TestListQuestion {
  id: number;
  question: string;
  difficulty: number;
  answers: string[];
  idDiscipline: number;
  idSubject: number;
  certified: boolean;
}

interface Answer {
  value: string;
  isCorrect: boolean;
}

interface TestListQuestionProps {
  id: number;
}

// DUVIDA isso é uma ideia, fica legal? talvez usar ícones melhores
const Legend = () => {
  return (
    <div className="row text-center mb-3">
      <div className="col-md-12 ml-3">
        <span className="mr-2 mx-2"><AiOutlineSafetyCertificate style={{ color: 'green' }} /></span>
        Question approved by an certifier
        <span className="mr-2 mx-2"><AiOutlineSafetyCertificate style={{ color: 'red' }} /></span>
        Question disapproved by an certifier
        <span className="mr-2 mx-2"><AiOutlineSafetyCertificate style={{ color: 'black' }} /></span>
        Question does not evaluate by an certifier
      </div>
    </div>
  );
};

const TestListQuestionTable = ({ id }: TestListQuestionProps) => {
  const [testQuestions, setTestQuestions] = useState<TestListQuestion[]>([]);

  useEffect(() => {
    // Fetch the test results for the student with the given ID
    fetch(`${config.url.BASE_URL}/questions`, configHeader)
      .then(response => response.json())
      // TODO backend está paginando essa rota, por padrão vai retornar a página 0 com 10 itens dentro do content. Necessário adicionar lógica de pagina aqui no frontend. Pode usar usar page e size no query Parameter pra pegar a página e o tamanho que quiser, por exemplo, /questions?page=1&size=5

      .then(data => setTestQuestions(data['content']));
  }, [id]);

  return (
    <div className="container">
      <Legend />
      <div className="row text-center">
        <p className="h2">Questions</p>
      </div>
      {/* // TODO estilizar esse trecho, talvez alterar os radios por buttons. Deixar parecido com o do qconcursos */}
      {testQuestions.map((question, index) => (
        <div className="row" key={question.id}>
          <div className="col-sm-auto">
            <p className="h4">{`${index + 1}. ${question.question}`}</p>
          </div>
          <div className="col-sm-auto">

            {question.certified  ?
            <AiOutlineSafetyCertificate style={{ fontSize: '24px', color: 'green' }} />
            : question.certified === false ?
            <AiOutlineSafetyCertificate style={{ fontSize: '24px', color: 'red' }} />
            :
            <AiOutlineSafetyCertificate style={{ fontSize: '24px', color: 'black' }} />}

          </div>
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
      ))}

      <Outlet />
    </div>
  );
};

export default TestListQuestionTable;
