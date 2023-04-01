import path from 'path';
import { useContext } from 'react';
import { Col, Row } from 'react-bootstrap';
import { Outlet } from 'react-router-dom';
import { AuthContext } from '../context/authContext';
import Navbar from './Navbar';
import Sidebar, { MenuData } from './Sidebar';


//FIXME arrumar as cores definitivas
//Testando as ROLES
/** ROLE_TEACHER,
    ROLE_STUDENT,
    ROLE_CERTIFIER */
export default function NavSideBarComponent() {
    const auth = useContext(AuthContext);

    const MenuRoles: { [role: string]: MenuData } = {
        ROLE_TEACHER: {
            links: [
                {
                    text: 'Cadastrar Questão',
                    path: '#'
                }
            ],
            styles: [
                {
                    path: 'col-10 min-vh-100 role_teacher_color_schema align-text-center'
                }
            ]
        },
        ROLE_STUDENT: {
            links: [
                {
                    text: 'BUSCAR PROVA',
                    path: '#'
                }
            ],
            styles: [
                {
                    path: 'col-10 min-vh-100 role_student_color_schema align-text-center'
                }
            ]
        },
        ROLE_CERTIFIER: {
            links: [
                {
                    text: 'QUESTÕES PARA APROVAÇÃO',
                    path: '#'
                }
            ],
            styles: [
                {
                    path: 'col-10 min-vh-100 role_certifier_color_schma align-text-center'
                }
            ]
        }
        //TESTE COM ALGUMAS QUESTÕES ALTERANDO DINAMICAMENTE
    }
    return (
        <>

            <Navbar />
            <Row>
                <Col className='col-2'><Sidebar {...MenuRoles[auth.user?.role[0].authority || 'ROLE_USER']} /></Col>
                <Col><Outlet /></Col>
            </Row>
        </>
    )

}