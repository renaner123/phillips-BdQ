import React from 'react';
import { Carousel, Container, Navbar, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Outlet } from 'react-router-dom';
import NavBarLogin from '../components/NavbarLogin';
import Sidebar from '../components/Sidebar';
import FooterComponent from '../components/Footer';
import CarouselComponent from '../components/Carousel';
import Card1 from '../components/Cards/Card1';
import Card2 from '../components/Cards/Card2';
import Card3 from '../components/Cards/Card3';

export default function Institutional() {
    return (
        <>
            <CarouselComponent />
            <div className="container marketing">
                <div className="row">
                    <div className="col-lg-4">
                        <Card1 />
                    </div>
                    <div className="col-lg-4">
                        <Card2 />
                    </div>
                    <div className="col-lg-4">
                        <Card3 />
                    </div>
                </div>
                <hr className="featurette-divider" />
            </div>
            {/* realizar um componente*/}
            <FooterComponent />

        </>
    )
}
