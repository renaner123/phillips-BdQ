
import { Card } from 'react-bootstrap';
import formatura from '../../assets/Images/pexels-emily-ranquist-1205651.jpg'
import provasGeracao from '../../assets/Images/pexels-lee-campbell-89724.jpg';


export default function Card2() {
    return (
        <>


            <Card className="bg-dark text-white">
                <Card.Img src={provasGeracao} alt="Card image" />
                <Card.ImgOverlay>
                    <Card.Title className='mt-5'>Provas geradas automaticamente</Card.Title>
                    <Card.Text className='mt-4'>
                    Provas geradas pelo nosso sistema técnologico, para o melhor aproveitamento e acertividade
                    </Card.Text>
                    <Card.Text className='mt-3'><a href="/register" className="btn btn-secondary">Junte-se a nós! &raquo;</a></Card.Text>
                </Card.ImgOverlay>
            </Card>
        </>
    )
}

/**                        <img src={provasGeracao} className="img-thumbnail rounded-circle" role='img' alt="..." style={{ objectFit: 'cover', width: '140px', height: '140px' }} />
                        <h2 className="fw-normal my-2">Provas geradas automaticamente</h2>
                        <p className='my-3'>Provas sendo geradas pelo nosso sistema técnologico, para o melhor aproveitamento e acertividade.</p>
                        <p><a className="btn btn-secondary" href="#">Junte-se a nós! &raquo;</a></p> */