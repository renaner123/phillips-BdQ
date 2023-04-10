import { text } from 'body-parser';
import { useContext } from 'react';
import { Col, Row } from 'react-bootstrap';
import { Outlet } from 'react-router-dom';
import { AuthContext } from '../context/authContext';
import Navbar, { MenuNavBarData } from './Navbar';
import Sidebar, { MenuData } from './Sidebar';


//FIXME arrumar as cores definitivas
//Testando as ROLES
/** ROLE_TEACHER,
    ROLE_STUDENT,
    ROLE_CERTIFIER */
export default function NavSideBarComponent() {
    const auth = useContext(AuthContext);

    const MenuNavBarRoles: { [role: string]:MenuNavBarData } = {
        ROLE_TEACHER:{
            links: [
                {
                    text: 'Home',
                    path_link: '/index/home'
                },
                {
                    text: 'Listar material',
                    path_link: '/index/download'
                }
            ],
            userScreen: [
                {
                    text_name: auth.user?.name!,
                    role: auth.user?.role[0].authority!
                }
            ],
            
        },
        ROLE_STUDENT:{
            links: [
                {
                    text: 'Home',
                    path_link: '/index/home'
                },
                {
                    text: 'Listar material',
                    path_link: '/index/download'
                }
            ],
            userScreen: [
                {
                    text_name: auth.user?.name!,
                    role: auth.user?.role[0].authority!
                }
            ],
           
        },
        ROLE_CERTIFIER:{
            links: [
                {
                    text: 'Home',
                    path_link: '/index/home'
                },
                {
                    text: 'Listar material',
                    path_link: '/index/download'
                }
            ],
            userScreen: [
                {
                    text_name: auth.user?.name!,
                    role: auth.user?.role[0].authority!
                }
            ],

        }
    }


    const MenuRoles: { [role: string]: MenuData } = {
        ROLE_TEACHER: {
            links: [
                {
                    text: 'Cadastrar Questão',
                    path: '/index/questions'
                },
                {
                    text: 'Listar Questões',
                    path: '/index/list-questions'
                },
                {
                    text: 'Adicionar Materiais',
                    path: '/index/upload'
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
                    text: 'Buscar Prova',
                    path: '/index/performance'
                },
                {
                    text: 'Responder Prova',
                    path: '/index/filterQuestion'
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
                    text: 'Questões para aprovação',
                    path: '/index/tests-certifieds'
                }
            ],
            styles: [
                {
                    path: 'col-10 min-vh-100 role_certifier_color_schma align-text-center'
                }
            ]
        }
        
    }
    return (
        <>
            
            <Navbar {...MenuNavBarRoles[auth.user?.role[0].authority || 'ROLE_USER']}/>
            <Row>
                <Col className='col-2'>
                    <Sidebar {...MenuRoles[auth.user?.role[0].authority || 'ROLE_USER']} />
                </Col>
                <Col>
                    <Outlet />
                </Col>
            </Row>
            
            
        </>
        
    )

}