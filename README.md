# Order Summary System

Exercício de Programação Orientada a Objetos em Java: leitura dos dados de um pedido (com N itens, definido pelo usuário) e exibição de um sumário formatado do pedido.

## 📋 Descrição

O programa lê os dados de um cliente e de um pedido — incluindo uma quantidade variável de itens (produto + preço + quantidade) — e ao final exibe um resumo completo do pedido, com subtotais por item e o valor total.

## 🗂 Modelo de domínio

O projeto segue o diagrama de classes abaixo:

- **Client**: dados do cliente (nome, e-mail, data de nascimento)
- **Order**: pedido, com data/hora (`moment`), status (`OrderStatus`) e uma lista de itens (`OrderItem`)
- **OrderItem**: item do pedido, contendo quantidade, preço e o produto associado; calcula o subtotal (`price * quantity`)
- **Product**: produto (nome e preço)
- **OrderStatus** *(enum)*: `PENDING_PAYMENT`, `PROCESSING`, `SHIPPED`, `DELIVERED`

### Relações
- Um `Order` possui vários `OrderItem` (associação 1 – *N*)
- Cada `OrderItem` está associado a um único `Product` (associação 1 – 1)
- Cada `Order` está associado a um único `Client`

## ▶️ Como executar

1. Clone o repositório
2. Importe o projeto no Eclipse (ou IDE de sua preferência) como projeto Java existente
3. Execute a classe `application.Program`
4. Informe os dados solicitados no console:
   - Dados do cliente (nome, e-mail, data de nascimento)
   - Status do pedido
   - Quantidade de itens e, para cada um, nome do produto, preço e quantidade

## 💻 Exemplo de execução

```
Enter cliente data:
Name: Alex Green
Email: alex@gmail.com
Birth date (DD/MM/YYYY): 15/03/1985
Enter order data:
Status: PROCESSING
How many items to this order? 2
Enter #1 item data:
Product name: TV
Product price: 1000.00
Quantity: 1
Enter #2 item data:
Product name: Mouse
Product price: 40.00
Quantity: 2

ORDER SUMMARY:
Order moment: 28/08/2026 17:30:11
Order status: PROCESSING
Client: Alex Green (15/03/1985) - alex@gmail.com
Order items:
TV, $1000.00, Quantity: 1, Subtotal: $1000.00
Mouse, $40.00, Quantity: 2, Subtotal: $80.00
Total price: $1080.00
```

## 🛠 Tecnologias

- Java
- `java.time.LocalDate` / `java.time.format.DateTimeFormatter` (data de nascimento)
- `java.util.Date` (instante do pedido)
- `java.util.Scanner` (leitura de entrada, com `Locale.US` para números decimais com ponto)

## 📚 Conceitos praticados

- Orientação a objetos (encapsulamento, construtores, getters/setters)
- Associações entre classes (agregação `Order`–`OrderItem`, associação `OrderItem`–`Product`)
- Enumerações (`enum`)
- Formatação de datas e valores monetários (`String.format`, `SimpleDateFormat`)
- Coleções (`List`, `ArrayList`) e laços de repetição
