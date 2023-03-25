import { faPlus } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Button, Container, Navbar } from "react-bootstrap";

export default function NavBarLogin() {
    return (


        <Navbar className="navbar navbar-dark bg-dark">
            <div className="d-flex justify-content-end w-100 ">
                <Button className="my-2 my-sm-0 mx-4 bg-dark ">
                    <span><FontAwesomeIcon icon={faPlus} /> Login</span>                 
                </Button>
            </div>
        </Navbar>

    )
}