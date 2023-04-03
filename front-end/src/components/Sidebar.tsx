import React, { useContext } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Row } from 'react-bootstrap';
import ReactDom from 'react-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faLocationPin } from '@fortawesome/free-solid-svg-icons';
import { AuthContext } from '../context/authContext';
import { link } from 'fs';
import { Link } from 'react-router-dom';

//Tipos de dados para alterar entre roles no sideBar
type LinksData = {
    text: string
    path: string
}

type StyleOfRolesData = {
    path: string
}

export type MenuData = {
    links: LinksData[]
    styles: StyleOfRolesData[]
}

export default function Sidebar({ links, styles }:MenuData) {
    const auth = useContext(AuthContext);

    function signOut() {
        if (auth.updateUser) auth.updateUser(undefined)
    }
    return (
        <>
            <div className="container-fluid">
                <Row>
                    {styles.map( (teste) =>{
                        return (
                            <div className={teste.path}>
                                <ul>
                            {links.map((link) => {
                                return (
                                    // FIXME essa key a principio tá gerando warning -> Warning: Each child in a list should have a unique "key" prop.
                                    <li key={link.path} className='nav-item'>
                                        <Link to={link.path} className='nav-link text-white' aria-current='page'>
                                            {(link.text)}
                                        </Link>
                                    </li>
                                )
                            })}
                        </ul>
                            </div>
                        )
                    })}
                </Row>
            </div>
        </>

    )

}

/**
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
                            </li> */


                            /**<Row>
                    <div className='col-10 min-vh-100 bg-primary align-text-center'>
                        <ul>
                            {links.map((link) => {
                                return (
                                    <li key={link.path} className='nav-item'>
                                        <Link to={link.path} className='nav-link text-white' aria-current='page'>
                                            {(link.text)}
                                        </Link>
                                    </li>
                                )
                            })}
                        </ul>
                    </div>
                </Row> */