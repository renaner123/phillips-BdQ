import React, { useState, useEffect, useContext } from "react";
import axios from "axios";
import { Outlet } from "react-router-dom";
import { config } from "../Constant";
import { AuthContext } from "../context/authContext";
import configHeader from "../services/ConfigHeader";
import { Button, OverlayTrigger, Popover } from "react-bootstrap";
import PopoverExtensions from "../components/Popover";
import { useAPI } from "../services/Api";

type LoginData = {
  username: string,
  password: string
}

function FileList() {
  const auth = useContext(AuthContext);
  const [stateFindTag, setStateFindTag] = useState('');
  const [files, setFiles] = useState<any[]>([]);
  const [state, setState] = useState<LoginData>({ username: '', password: '' });
  const [stateTags, setStateTags] = useState(Array(files.length).fill(""));
  const api = useAPI();

  // os 3 primeiros arquivos do banco não possuem link, para testar é necessário fazer o upload de arquivos
  useEffect(() => {
    axios
      .get(`${config.url.BASE_URL}/materials`, configHeader)
      .then((response) => {
        setFiles(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);
  

  const filterTag = (stateFindTag:string) =>{
    api.get(`/materials/${stateFindTag}`, {})
    .then((response) => setFiles(response))
    .catch(error => console.error(error));

  }

  const sendTag = (stateQuestionID: number, stateTags: string) => {
    api.put(`/materials/tags/${stateQuestionID}?tag=${stateTags}`, {})
      .then((response) => response.data)
      .catch(error => console.error(error));
    console.log(stateTags);
  };

  const handleFindTagChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setStateFindTag(event.target.value);
  }

  const handleSingularTagChange = (event: React.ChangeEvent<HTMLInputElement>, index: number) => {
    const newTags = [...stateTags];
    newTags[index] = event.target.value;
    setStateTags(newTags);
  };

  const downloadFile = (id: any) => {
    // FIXME retirar login estático - Exemplo no Arquivo TestCertifieds.tsx
    axios
      .get(`${config.url.BASE_URL}/materials/download-file/${id}`, configHeader)
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
      <PopoverExtensions />
      <div className="row">
        <div className="col-6">
          <div className="form-group">
            <input type="text"
              className="form-control"
              id="example-input"
              placeholder="TAG"
              value={stateFindTag}
              onChange={(event) =>
                handleFindTagChange(event)
              }
            />
          </div>
        </div>
        <div className="col-6">
          <button onClick={() => filterTag(stateFindTag)}>Filtrar Tag</button>
        </div>
      </div>


      <table className="table table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>TAG</th>
            <th>Date Uploaded</th>
            <th>Download</th>
            <th>Cadastrar TAG</th>
          </tr>
        </thead>

        <tbody>
          {files.map((file, index) => (
            <tr key={file.id}>
              <td>{file.id}</td>
              <td>{file.fileName}</td>              
              <td>{file.uploadDate}</td>
              <td>
                <button
                  className="btn btn-primary"
                  onClick={() => downloadFile(file.id)}
                >
                  Download
                </button>
              </td>
              <td>
                <div className="row">
                    <div className="form-group">
                      <input type="text"
                        key={index}
                        className="form-control"
                        id="example-input"
                        placeholder="TAG"
                        value={stateTags[index]}
                        onChange={(event) => handleSingularTagChange(event, index)}
                      />
                  </div>
                </div>
              </td>
              <td>
                <button
                  className="btn btn-success"
                  onClick={() => sendTag(parseInt(file.id), stateTags[index])}>
                  Cadastrar
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Outlet />
    </div>
  );
}

export default FileList;
