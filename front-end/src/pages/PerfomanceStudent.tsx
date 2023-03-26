import { useEffect, useState } from 'react';
import { Table } from 'react-bootstrap';
import { Outlet } from 'react-router-dom';
import config from '../services/ConfigHeader';

interface StudentTestResult {
  idTest: number;
  result: number;
  name: string;
  date: string;
}

interface StudentTestResultProps {
  studentId: number;
}

const StudentTestResultTable = ({ studentId }: StudentTestResultProps) => {
  const [testResults, setTestResults] = useState<StudentTestResult[]>([]);

  useEffect(() => {
    // Fetch the test results for the student with the given ID
    fetch(`http://127.0.0.1:8080/students/performance/${studentId}`, config)
      .then(response => response.json())
      .then(data => setTestResults(data));
  }, [studentId]);
  const getColorForResult = (result: number) => {
    return result >= 6 ? 'success' : 'danger';
  };

  return (
    <div className="container">
      <div className="row text-center">
        <h1>Student's performance</h1>
      </div>

      <table className="table table-striped">
        <thead>
          <tr>
            <th>Test ID</th>
            <th>Name</th>
            <th>Date</th>
            <th>Result</th>
          </tr>
        </thead>
        <tbody>
          {testResults.sort((a,b) => b.result - a.result).map((result) => (
            <tr key={result.date}>
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
      <Outlet/>
    </div>
  );
};

export default StudentTestResultTable;


