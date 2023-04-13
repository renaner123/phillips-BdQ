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
    if(stateFindTag.length>0){
      api.get(`/materials/${stateFindTag}`, {})
      .then((response) => setFiles(response))
      .catch(error => console.error(error));
      setStateFindTag("")
    }else{
      api.get(`/materials`, {})
      .then((response) => setFiles(response))
      .catch(error => console.error(error));
    }
  }

  const sendTag = (stateQuestionID: number, tag: string) => {
    api.put(`/materials/tags/${stateQuestionID}?tag=${stateTags}`, {})
      .then((response) => response.data)
      .catch(error => console.error(error));
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
    <div className="col-sm-6">
      <div className="form-group">
        <input 
          type="text"
          className="form-control"
          id="example-input"
          placeholder="TAG"
          value={stateFindTag}
          onChange={(event) => handleFindTagChange(event)}
        />
      </div>
    </div>
    <div className="col-sm-6">
      <button className="btn btn-primary" onClick={() => filterTag(stateFindTag)}>Filtrar Tag</button>
    </div>
  </div>
  <hr/>
  <div className="row">
    <div className="col-sm-1 mb-2 h5">ID</div>
    <div className="col-sm-2 h5">Name</div>
    <div className="col-sm-2 h5">Date Uploaded</div>
    <div className="col-sm-2 h5">Download</div>
  </div>
  {files.map((file, index) => (
    <div className="row" key={file.id}>
      <div className="col-sm-1 mb-2 mt-2">{file.id}</div>
      <div className="col-sm-2 mb-2 mt-2">{file.fileName}</div>
      <div className="col-sm-2 mb-2 mt-2">{file.uploadDate}</div>
      <div className="col-sm-2 mb-1 mt-1">
        <button
          className="btn btn-primary btn-sm"
          onClick={() => downloadFile(file.id)}
        >
          Download
        </button>
      </div>
      <div className="col-sm-2">
        <div className="form-group">
          <input
            type="text"
            key={index}
            className="form-control"
            id="example-input"
            placeholder="TAG"
            value={stateTags[index]}
            onChange={(event) => handleSingularTagChange(event, index)}
          />
        </div>
      </div>
      <div className="col-sm-3">
        <button
          className="btn btn-success btn-sm"
          onClick={() => sendTag(parseInt(file.id), stateTags[index])}
        >
          Cadastrar
        </button>
      </div>
    </div>
  ))}
  <Outlet />
</div>
  );
}

export default FileList;
