import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Row } from 'react-bootstrap';
import ReactDom from 'react-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faLocationPin } from '@fortawesome/free-solid-svg-icons';

export default function Sidebar() {
    return (
        <>
            <div className="container-fluid">
                <Row>
                    <div className="col-10 min-vh-100 bg-success align-text-center">
                        <ul>
                            <li>
                                <a href="" className="nav-link px-2 mt-3">
                                    <FontAwesomeIcon className="style-off" icon={faLocationPin} />
                                    <span className="ms-1 d-none d-sm-inline style-off">HOME</span>

                                </a>
                            </li>
                            <li>
                                <a href="" className="nav-link px-2 mt-3">
                                    <FontAwesomeIcon className="style-off" icon={faLocationPin} />
                                    <span className="ms-1 d-none d-sm-inline style-off ">ENVIAR PARA CERTIFICAÇÃO</span>

                                </a>
                            </li>
                            <li>
                                <a href="" className="nav-link px-2 mt-3">
                                    <FontAwesomeIcon className="style-off" icon={faLocationPin} />
                                    <span className="ms-1 d-none d-sm-inline style-off">GG</span>

                                </a>
                            </li>
                        </ul>
                    </div>
                </Row>
            </div>
        </>

    )

}

