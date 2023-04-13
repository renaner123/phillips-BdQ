import { error } from 'console';
import test from 'node:test';
import { useEffect, useState } from 'react';
import { Table } from 'react-bootstrap';
import { Outlet } from 'react-router-dom';
import { config } from '../Constant';
import configHeader from '../services/ConfigHeader';


interface StudentTestResult {
  idTest: number;
  result: number;
  name: string;
  date: string;
}

interface StudentTestResultProps {
  studentId: number;
}

//let erroStatus;

const StudentTestResultTable = ({ studentId }: StudentTestResultProps) => {
  const [testResults, setTestResults] = useState<StudentTestResult[]>([]);


    // FIXME retirar login estático - Exemplo no Arquivo TestCertifieds.tsx
  useEffect(() => {
    // Fetch the test results for the student with the given ID
    fetch(`${config.url.BASE_URL}/students/performance/${studentId}`, configHeader)
      .then(response => response.json())
      .then(data => setTestResults(data))
      console.log(testResults);
  }, [studentId]);
  const getColorForResult = (result: number) => {
    return result >= 6 ? 'success' : 'danger';
  };

  //console.log( erroStatus + " aloan");


  /**.catch((error) => {       
            if(error.response.status===409){
              alert(error.response.data['message'])
            }else if(error.response.status===400){
              alert(error.response.data[0]['message'])
            }
            console.log(error);   */
  return (
    <div className="container">


      <div className="row text-center">
        <p className="h2">Performance do estudante</p>
      </div>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Test ID</th>
            <th>Nome</th>
            <th>Data</th>
            <th>Resultado</th>
          </tr>
        </thead>
        <tbody>
        {Array.isArray(testResults) && testResults.sort((a,b) => b.result - a.result).map((result) => (
            <tr key={result.idTest}>
              <td>{result.idTest}</td>
              <td>{result.name}</td>
              <td>{result.date}</td>
              <td>
                <span className={`badge bg-${getColorForResult(result.result)}`}>{result.result}</span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Outlet />
    </div>
  );
};

export default StudentTestResultTable;


