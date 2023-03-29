import { Carousel, Container } from "react-bootstrap";


export default function CarouselComponent() {
    return (
        <>
            <Carousel id="myCarousel" className="Carousel-background" >
                <Carousel.Item>
        
                    <Carousel.Caption className="text-start">
                        <h3>Seja nosso aluno!</h3>
                        <p>Através do nosso portal, você conseguirá realizar provas com questões selecionadas pelos nossos clientes! </p>
                        <p><a className="btn btn-lg btn-primary" href="/register">Inscreva-se</a></p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>

                    <Carousel.Caption>
                        <h3>Já nosso aluno?</h3>
                        <p>Faça o LOGIN e continue o seu estudo! </p>
                        <p><a className="btn btn-lg btn-primary" href="/login">Login</a></p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>

                    <Carousel.Caption className="text-end">
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


