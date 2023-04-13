import { Button, Card, Col, Container, Row } from "react-bootstrap";


export default function NotFound() {
    return(
        <Container>
        <Row className="justify-content-center">
          <Col md={6}>
            <Card className="mt-5">
              <Card.Header>Not Found - ERRO Pedestre</Card.Header>
              <Card.Body>
                <Card.Title className="my-2">Desculpe, mas essa página não existe. </Card.Title>
                <Card.Text className="my-4">
                  Por favor verifique a URL digitada e tente novamente!
                  Em caso de duvida, contate a equipe de suporte!
                </Card.Text>
                <Button variant="primary" href="/">Home</Button>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    )
}