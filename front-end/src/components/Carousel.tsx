import { Carousel, Container } from "react-bootstrap";
import teachersHappy from '../assets/Images/pexels-yan-krukau-8617834.jpg';
import studentHappy from '../assets/Images/pexels-andrea-piacquadio-3768126.jpg';
import classHappy from '../assets/Images/pexels-ron-lach-10646410.jpg';


export default function CarouselComponent() {
    return (
        <>
            <Carousel id="myCarousel" className="Carousel-background" >
                <Carousel.Item>
                <img src={classHappy} className="img-thumbnail" role='img' alt="..." style={{ objectFit: 'cover', width: '100%', height: '100%' }} />
                    <Carousel.Caption className="text-start">
                        <h3>Seja nosso aluno!</h3>
                        <p>Através do nosso portal, você conseguirá realizar provas com questões selecionadas pelos nossos clientes! </p>
                        <p><a className="btn btn-lg btn-primary" href="/register">Inscreva-se</a></p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <img src={studentHappy} className="img-thumbnail" role='img' alt="..." style={{ objectFit: 'cover', width: '100%', height: '100%' }} />
                    <Carousel.Caption>
                        
                        <h3 className="style-sombra">Já nosso aluno?</h3>
                        <p>Faça o LOGIN e continue o seu estudo! </p>
                        <p><a className="btn btn-lg btn-primary" href="/login">Login</a></p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img src={teachersHappy} className="img-thumbnail" role='img' alt="..." style={{ objectFit: 'cover', width: '100%', height: '100%' }} />
                    <Carousel.Caption className="text-end ">

                        <h3>Quer ser um professor ou certificador?</h3>
                        <p>
                            Entre em contato conosco!
                        </p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
        </>
    )
}


