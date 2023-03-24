import { Col, Row } from 'react-bootstrap';
import { Outlet } from 'react-router-dom';
import Navbar from './Navbar';
import Sidebar from './Sidebar';

export default function NavSideBarComponent() {
    return (
        <>

            <Navbar />
            <Row>
                <Col className='col-2'><Sidebar /></Col>
                <Col><Outlet/></Col>
            </Row>  
        </>
    )

}