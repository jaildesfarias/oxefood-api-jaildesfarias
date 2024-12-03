import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import axios from 'axios';
import InputMask from 'react-input-mask';

const VendaForm = () => {
    const [statusVenda, setStatusVenda] = useState('');
    const [dataVenda, setDataVenda] = useState('');
    const [retiradaEmLoja, setRetiradaEmLoja] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('/venda', {
                statusVenda,
                dataVenda,
                retiradaEmLoja,
            });
            alert('Venda salva com sucesso!');
        } catch (err) {
            alert('Erro ao salvar venda!');
        }
    };

    return (
        <Form onSubmit={handleSubmit}>
            {/* Campo Status da Venda */}
            <Form.Group controlId="statusVenda">
                <Form.Label>Status da Venda</Form.Label>
                <Form.Select
                    value={statusVenda}
                    onChange={(e) => setStatusVenda(e.target.value)}
                    required
                >
                    <option value="">Selecione</option>
                    <option value="Pedido Cancelado">Pedido Cancelado</option>
                    <option value="Aguardando Pagamento">Aguardando Pagamento</option>
                    <option value="Pago">Pago</option>
                    <option value="Entregue">Entregue</option>
                </Form.Select>
            </Form.Group>

            {/* Campo Data da Venda */}
            <Form.Group controlId="dataVenda">
                <Form.Label>Data da Venda</Form.Label>
                <InputMask
                    mask="99/99/9999"
                    value={dataVenda}
                    onChange={(e) => setDataVenda(e.target.value)}
                >
                    {(inputProps) => (
                        <Form.Control
                            {...inputProps}
                            type="text"
                            placeholder="DD/MM/AAAA"
                            required
                        />
                    )}
                </InputMask>
            </Form.Group>

            {/* Campo Retirada em Loja */}
            <Form.Group controlId="retiradaEmLoja">
                <Form.Label>Retirada em Loja</Form.Label>
                <Form.Check
                    type="radio"
                    label="Sim"
                    value={true}
                    name="retiradaEmLoja"
                    onChange={() => setRetiradaEmLoja(true)}
                />
                <Form.Check
                    type="radio"
                    label="Não"
                    value={false}
                    name="retiradaEmLoja"
                    onChange={() => setRetiradaEmLoja(false)}
                />
            </Form.Group>

            {/* Botão para Submeter */}
            <Button variant="primary" type="submit">
                Salvar Venda
            </Button>
        </Form>
    );
};

export default VendaForm;
