

import { useEffect, useState } from 'react';
import { Table } from 'react-bootstrap';
import { Outlet } from 'react-router-dom';
import { config } from '../Constant';
import configHeader from '../services/ConfigHeader';
import { FaBeer } from 'react-icons/fa';
import { AiOutlineSafetyCertificate } from "react-icons/ai";
import { parse } from 'path';

// FIXME adicionar um botão de "search" pra mostrar só as certificadas/não certificadas
// FIXME ajustar para celular, tá esquisito

interface ListQuestion {
    id: number;
    question: string;
    difficulty: number;
    answers: string[];
    idDiscipline: number;
    idSubject: number;
    certified: boolean;
}

// Por enquanto está estatico
const listOfOptions = [
    { value: '1', label: 'Matemática' },
    { value: '2', label: 'Portugues' },
    { value: '3', label: 'Programacao' }
];


interface FilterQuestionProp {
    idDiscipline: number;
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

const FiltroDisciplinas = ({ idDiscipline }: FilterQuestionProp) => {
    const [stateDiscipline, setStateDiscipline] = useState('');
    const [stateSubject, setStateSubject] = useState('');
    const [listQuestions, setListQuestions] = useState<ListQuestion[]>([]);

    //#TODO finalizar o código para recuperar os dados
    let idDis = parseInt(stateDiscipline);
    let idSub = parseInt(stateSubject);
    let fullURL: RequestInfo | URL;

    fullURL = `${config.url.BASE_URL}/questions/certifieds`


    
    if (idDis > 0 && idSub > 0) {
        fullURL = `${config.url.BASE_URL}/questions/certifieds/${idDis}?id-subject=${idSub}`;
    } 
    console.log("Full URL" + fullURL);

 
    useEffect(() => {
        fetch(fullURL, configHeader)
            .then(response => response.json())
            .then(data => setListQuestions(data))
    }, [stateDiscipline, stateSubject]);

    return (
        <div className="container">
            <select className="form-select"
                value={stateDiscipline}
                onChange={(e) => { setStateDiscipline(e.target.value) }} >
                <option selected>Disciplina</option>
                {listQuestions?.map((op, index) => (
                    <option key={index} value={op.idDiscipline}>
                        {op.idDiscipline}
                    </option>
                ))}
            </select>
            <select className="form-select"
                value={stateSubject}
                onChange={(e) => { setStateSubject(e.target.value) }}
            >
                <option selected>Assunto</option>
                {listQuestions?.map((op, index) => (
                    <option key={index} value={op.idSubject}>
                        {op.idSubject}
                    </option>
                ))}
            </select>



            <div className="row text-center">
                <p className="h2">Questions</p>
            </div>

            {listQuestions.map((question, index) => (
                <>
                    <div className="row" key={question.id}>
                        <div className="col-sm-auto">
                            <p className="h4">{`${index + 1}. ${question.question}`}</p>
                        </div>
                        <div className="col-sm-auto">             {/** Removido a verificação da certificação, já que todas são certificadas*/}                    </div>
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
            ))}
            <Outlet />
        </div>
    );
};

export default FiltroDisciplinas;







/**<div className="row" key={question.id}>
                        <div className="col-sm-auto">
                            <p className="h4">{`${index + 1}. ${question.question}`}</p>
                        </div>
                        <div className="col-sm-auto">                               </div>
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
                    </div> */




/**import React, { useState } from "react";
import axios from "axios";
import { config } from "../Constant";
import configHeader from "../services/ConfigHeader";

interface Questoes {
    id: number;
    nome: string;
    assuntos: string[];
}



interface QuestoesTest{
    id: number;
    question: string;
    answers: string[];
    difficulty: number;
    certified: boolean;
    idDiscipline: number;
    tag: string;
    idSubject: number;
}

interface QuestoesTestProp{
    idDiscipline: number;
}

const getAllQuestions = () =>{
    try {
        axios.get(`${config.url.BASE_URL}/questions`, configHeader)
        .then((response) => {            
            console.log("Get all Questions: " + response.data);
        });
    } catch (e) {
        console.error("Erro em getAllQuestion" + e);
        
    }
}



const disciplinas: Questoes[] = [
    { id: 1, nome: "Matemática", assuntos: ["Álgebra", "Geometria", "Cálculo"] },
    { id: 2, nome: "Física", assuntos: ["Mecânica", "Termodinâmica", "Eletromagnetismo"] },
    { id: 3, nome: "Química", assuntos: ["Orgânica", "Inorgânica", "Físico-Química"] },
    { id: 4, nome: "História", assuntos: ["Antiga", "Medieval", "Moderna"] },
    { id: 5, nome: "Geografia", assuntos: ["Física", "Humana", "Econômica"] },
];

const FiltroDisciplinas = () => {
    const [pesquisaDisciplina, setPesquisaDisciplina] = useState("");
    const [disciplinaSelecionada, setDisciplinaSelecionada] = useState<Questoes | undefined>(undefined);
    const [pesquisaAssunto, setPesquisaAssunto] = useState("");
    const [assuntoSelecionado, setAssuntoSelecionado] = useState<string | undefined>(undefined);
    const [status, setStatus] = useState("");

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        axios.post("/api/disciplinas", {
            disciplina: disciplinaSelecionada?.nome,
            assunto: assuntoSelecionado
        })
        .then(response => {
            setStatus(response.data.message);
        })
        .catch(error => {
            setStatus(error.response.data.message);
        });
    };

    const handlePesquisarDisciplina = (event: React.ChangeEvent<HTMLInputElement>) => {
        setPesquisaDisciplina(event.target.value);
    };

    const disciplinasFiltradas = disciplinas.filter((disciplina) =>
        disciplina.nome.toLowerCase().includes(pesquisaDisciplina.toLowerCase())
    );

    const handleSelecionarDisciplina = (event: React.ChangeEvent<HTMLSelectElement>) => {
        const disciplinaId = Number(event.target.value);
        const disciplina = disciplinas.find((disciplina) => disciplina.id === disciplinaId);
        setDisciplinaSelecionada(disciplina);
    };

    const handlePesquisarAssunto = (event: React.ChangeEvent<HTMLInputElement>) => {
        setPesquisaAssunto(event.target.value);
    };

    const assuntosFiltrados = disciplinaSelecionada?.assuntos.filter((assunto) =>
        assunto.toLowerCase().includes(pesquisaAssunto.toLowerCase())
    );

    const handleSelecionarAssunto = (event: React.ChangeEvent<HTMLSelectElement>) => {
        const assunto = event.target.value;
        setAssuntoSelecionado(assunto);
    };

    // #TODO Finalizar colocando o tag e realizando alguns testes

    return (
        <div>
            <h2>Disciplinas:</h2>
            <form onSubmit={handleSubmit}>
                
                <select onChange={handleSelecionarDisciplina} value={disciplinaSelecionada?.id}>
                    <option value="">Selecione uma disciplina</option>
                    {disciplinas.map((disciplina) => (
                        <option key={disciplina.id} value={disciplina.id}>
                            {disciplina.nome}
                        </option>
                    ))}
                </select>
                {disciplinaSelecionada && (
                    <>
                        <h2>Assuntos:</h2>                        
                        <select onChange={handleSelecionarAssunto} value={assuntoSelecionado}>
                            <option value="">Selecione um assunto</option>
                            {disciplinaSelecionada.assuntos.map((assunto) => (
                                <option key={assunto} value={assunto}>
                                    {assunto}
                                </option>
                            ))}
                        </select>
                        <button type="submit">Enviar</button>
                        {status && (
                            <>
                                <h2>Status:</h2>
                                <p>{status}</p>
                            </>
                        )}
                    </>
                )}
            </form>
        </div>
    );
    
};

export default FiltroDisciplinas; */


/**<div>
            <h2>Disciplinas:</h2>
            <input type="text" onChange={handlePesquisarDisciplina} placeholder="Pesquisar disciplina" />
            <select onChange={handleSelecionarDisciplina} value={disciplinaSelecionada?.id}>
                <option value="">Selecione uma disciplina</option>
                {disciplinas.map((disciplina) => (
                    <option key={disciplina.id} value={disciplina.id}>
                        {disciplina.nome}
                    </option>
                ))}
            </select>
            {disciplinaSelecionada && (
                <>
                    <h2>Assuntos:</h2>
                    <input type="text" onChange={handlePesquisarAssunto} placeholder="Pesquisar assunto" />
                    <select onChange={handleSelecionarAssunto} value={assuntoSelecionado}>
                        <option value="">Selecione um assunto</option>
                        {disciplinaSelecionada.assuntos.map((assunto) => (
                            <option key={assunto} value={assunto}>
                                {assunto}
                            </option>
                        ))}
                    </select>
                    {assuntoSelecionado && (
                        <>
                            <h2>Resultado:</h2>
                            <p>Disciplina: {disciplinaSelecionada.nome}</p>
                            <p>Assunto: {assuntoSelecionado}</p>
                        </>
                    )}
                </>
            )}
        </div> */

