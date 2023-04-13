
import { Card } from 'react-bootstrap'
import formatura from '../../assets/Images/pexels-emily-ranquist-1205651.jpg'

export default function Card1() {
    return (
        <>


            <Card className="bg-dark text-white">
                <Card.Img src={formatura} alt="Card image" />
                <Card.ImgOverlay>
                    <Card.Title className='mt-5 '><h5>Auto índice de aprovação!</h5></Card.Title>
                    <Card.Text className='mt-4'>
                        9 em cada 10 alunos, nos relatam bons resultados em sua vida acadêmica!
                    </Card.Text>
                    <Card.Text
                        className='mt-3'>
                    
                        <a href="/register" className="btn btn-secondary">Junte-se a nós! &raquo;</a>
                    </Card.Text>
                </Card.ImgOverlay>
            </Card>
        </>
    )
}

