import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import axios from 'axios';
import InputMask from 'react-input-mask';(web)

    return (
        <Form onSubmit={handleSubmit}>
            {error && <p className="text-danger">{error}</p>} {/* Exibição de erro */}

            <Form.Group controlId="statusVenda" className="mb-3">
                <Form.Label>Status da Venda</Form.Label>
                <Form.Select
                    value={statusVenda}
                    onChange={(e) => setStatusVenda(e.target.value)}
                    required
                    aria-label="Selecione o status da venda"
                >
                    <option value="">Selecione</option>
                    <option value="Pedido Cancelado">Pedido Cancelado</option>
                    <option value="Aguardando Pagamento">Aguardando Pagamento</option>
                    <option value="Pago">Pago</option>
                    <option value="Entregue">Entregue</option>
                </Form.Select>
            </Form.Group>

            <Form.Group controlId="dataVenda" className="mb-3">
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
                            aria-label="Insira a data da venda"
                        />
                    )}
                </InputMask>
            </Form.Group>

            <Form.Group controlId="retiradaEmLoja" className="mb-3">
                <Form.Label>Retirada em Loja</Form.Label>
                <Form.Check
                    type="radio"
                    label="Sim"
                    value={true}
                    name="retiradaEmLoja"
                    checked={retiradaEmLoja === true}
                    onChange={() => setRetiradaEmLoja(true)}
                />
                <Form.Check
                    type="radio"
                    label="Não"
                    value={false}
                    name="retiradaEmLoja"
                    checked={retiradaEmLoja === false}
                    onChange={() => setRetiradaEmLoja(false)}
                />
            </Form.Group>

            <Button variant="primary" type="submit">
                Salvar Venda
            </Button>
        </Form>
    );
};

export default VendaForm;
