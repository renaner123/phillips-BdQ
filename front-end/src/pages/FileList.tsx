import React, { useState, useEffect } from "react";
import axios from "axios";
import { Outlet } from "react-router-dom";

function FileList() {
  const [files, setFiles] = useState<any[]>([]);
  // os 3 primeiros arquivos do banco não possuem link, para testar é necessário fazer o upload de arquivos
  useEffect(() => {
    axios
      .get("http://localhost:8080/materials")
      .then((response) => {
        setFiles(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const downloadFile = (id: any) => {
    const username = 'renan';
    const password = '123';
    const base64Credentials = btoa(`${username}:${password}`);
    
    axios
      .get(`http://localhost:8080/materials/download-file/${id}`, {
        responseType: "blob",
        headers: {
          Authorization: `Basic ${base64Credentials}`,
          'Content-Type': 'application/json',
          Accept: 'application/json',
        },
      })
      .then((response) => {
        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement("a");
        link.href = url;
        link.setAttribute("download", `${id}.pdf`);
        document.body.appendChild(link);
        link.click();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <div className="row text-center">
        <h1>List of Files</h1>
      </div>

      <table className="table table-striped">
        <thead>
          <tr>
          <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Date Uploaded</th>
            <th>Download</th>
          </tr>
        </thead>
        <tbody>
          {files.map((file) => (
            <tr key={file.id}>
              <td>{file.id}</td>
              <td>{file.fileName}</td>
              <td>{file.docType}</td>
              <td>{file.uploadDate}</td>
              <td>
                <button
                  className="btn btn-primary"
                  onClick={() => downloadFile(file.id)}
                >
                  Download
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Outlet/>
    </div>
  );
}

export default FileList;
