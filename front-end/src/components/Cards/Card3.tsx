
import formatura from '../../assets/Images/pexels-emily-ranquist-1205651.jpg'
import programadores from '../../assets/Images/pexels-cottonbro-studio-6804081.jpg';
import { Card } from 'react-bootstrap';
export default function Card3() {
    return (
        <>


            <Card className="bg-dark text-white">
                <Card.Img src={programadores} alt="Card image" />
                <Card.ImgOverlay>
                    <Card.Title className='mt-5'>Equipe em desenvolvimento constante</Card.Title>
                    <Card.Text className='mt-4'>
                    Desenvolvedores capacitados para gerar mecanismos para os alunos e professores.
                    </Card.Text>
                    <Card.Text className='mt-3'><a href="/register" className="btn btn-secondary">Junte-se a nós! &raquo;</a></Card.Text>
                </Card.ImgOverlay>
            </Card>
        </>
    )
}

/**                        <img src={programadores} className="img-thumbnail rounded-circle" role='img' alt="..." style={{ objectFit: 'cover', width: '140px', height: '140px' }} />
                        <h2 className="fw-normal my-2">Equipe em desenvolvimento constante</h2>
                        <p className='my-3'>Desenvolvedores altamente capacitados para gerar mecanismos para os nossos alunos e professores.</p>
                        <p><a className="btn btn-secondary" href="#">Junte-se a nós! &raquo;</a></p> */