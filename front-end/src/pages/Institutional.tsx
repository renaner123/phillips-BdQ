import React from 'react';
import { Carousel, Container, Navbar, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Outlet } from 'react-router-dom';
import NavBarLogin from '../components/NavbarLogin';
import Sidebar from '../components/Sidebar';
import FooterComponent from '../components/Footer';
import CarouselComponent from '../components/Carousel';

export default function Institutional() {
    return (
        <>
            <CarouselComponent />
            <div className="container marketing">
                <div className="row">
                    <div className="col-lg-4">
                        <svg className="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777" /><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
                        <h2 className="fw-normal">Auto indice de aprovação!</h2>
                        <p className='my-2'>9 em cada 10 alunos, nos relatam bons resultados em sua vida academica!</p>
                        <p><a className="btn btn-secondary" href="#">Junte-se a nós! &raquo;</a></p>
                    </div>
                    <div className="col-lg-4">
                        <svg className="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777" /><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
                        <h2 className="fw-normal">Um estoque de provas e questões geradas automaticamente</h2>
                        <p className='my-2'>Provas sendo geradas dinamicamente pelo nosso sistema técnologico, para o melhor aproveitamento e acertividade.</p>
                        <p><a className="btn btn-secondary" href="#">Junte-se a nós! &raquo;</a></p>
                    </div>
                    <div className="col-lg-4">
                        <svg className="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777" /><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
                        <h2 className="fw-normal">Equipe em desenvolvimento constante</h2>
                        <p className='my-2'>Contratamos uma equipe de desenvolvedores altamente capacitados para gerar mais mecanimos para ajudar os nossos alunos e professores.</p>
                        <p><a className="btn btn-secondary" href="#">Junte-se a nós! &raquo;</a></p>
                    </div>
                </div>
                <hr className="featurette-divider" />

                <div className="row featurette">
                    <div className="col-md-7">
                        <h2 className="featurette-heading fw-normal lh-1">Ao acessar nossa plataforma. <span className="text-muted">é bom estar preparado para altas surpresas!</span></h2>
                        <p className="lead my-3">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vitae dolores dolore deleniti ducimus corrupti esse delectus dicta reiciendis laudantium id enim dolor tempora, eum quae? Sunt ipsa possimus facere doloremque!</p>
                    </div>
                    <div className="col-md-5">
                        <svg className="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 500x500" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#eee" /><text x="50%" y="50%" fill="#aaa" dy=".3em">500x500</text></svg>
                    </div>
                </div>
                <hr className="featurette-divider" />
            </div>
            {/* realizar um componente*/}
            <FooterComponent />

        </>
    )
}
