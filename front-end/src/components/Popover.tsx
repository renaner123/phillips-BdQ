import { Button, OverlayTrigger, Popover } from "react-bootstrap";

const popover = (
    <Popover id="popover-basic">
      <Popover.Header as="h3">Tipos de Arquivos compativeis</Popover.Header>
      <Popover.Body>
        Por enquanto estamos na versão 1, e estamos aceitamos apenas PDF! 
      </Popover.Body>
    </Popover>
  );

export default function PopoverExtensions() {
    return (
        <OverlayTrigger trigger="click" placement="right" overlay={popover}>
            <Button variant="success">Extensões compativeis</Button>
        </OverlayTrigger>
    )
}