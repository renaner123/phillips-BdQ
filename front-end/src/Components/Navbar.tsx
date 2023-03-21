import react from 'react';
import Container from 'react-bootstrap/esm/Container';
import Navbar from 'react-bootstrap/Navbar';


export default function NavbarComponent() {
    return (
        <>
            <Navbar bg="dark" variant="dark">
                <Container>
                <nav aria-label="Page navigation example">
                    <ul className="pagination justify-content-center">
                      <li className="page-item"><a className="page-link pk" href="/">Login</a></li>
                      <li className="page-item"><a className="page-link pk" href="/download">Download</a></li>
                    </ul>
                  </nav>
                </Container>
            </Navbar>
        </>
    )
}