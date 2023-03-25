import React from 'react';
import { Carousel, Container, Navbar, Row } from 'react-bootstrap';
import { Outlet } from 'react-router-dom';
import Banner from '../components/Banner';
import NavBarLogin from '../components/NavbarLogin';
import Sidebar from '../components/Sidebar';

export default function Institutional() {
    return (
        <>
            <Container>
                <Row>
                    <Banner></Banner>
                </Row>
                <Row>
                    <Carousel>
                        
                    </Carousel>
                </Row>

            </Container>

        </>
    )
}
