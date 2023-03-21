import react from 'react';
import Container from 'react-bootstrap/esm/Container';
import Navbar from 'react-bootstrap/Navbar';


export default function NavbarComponent() {
    return (
        <>

            <Navbar bg="dark" variant="dark">
                <Container>
                    <div className="title-navbar-login">
                        Faça o seu Login
                    </div>
                </Container>
            </Navbar>
        </>
    )
}