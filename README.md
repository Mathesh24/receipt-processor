**Receipt Processor**

**Overview :**
This Spring Boot application processes receipts and calculates reward points. It provides RESTful APIs to submit receipts and retrieve associated points.

**Prerequisites**
Docker

**Project Setup**
Clone the repository:

**Bash**
git clone https://github.com/your-username/receipt-processor.git

Replace your-username with your actual GitHub username.

**Build the Docker image:**

 Bash
docker build -t receipt-processor .

**Run the Docker container:**

 Bash
docker run -p 8080:8080 receipt-processor

This will start the application on port 8080.

**API Endpoints**
Submit a receipt:

**POST /receipt/processor**
Request body:
{
  "retailer": "M&M Corner Market",
  "purchaseDate": "2022-03-20",
  "purchaseTime": "14:33",
  "items": [
    {
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    }
  ],
  "total": "9.00"
}


**Response:**

 JSON
{
  "id": "receipt_id"
}


**Get points for a receipt:
GET /receipt/{id}/points**
Replace {id} with the receipt ID returned from the previous endpoint.
Response:

 JSON
{
  "points": 123
}

**Get all processed receipts:**

**GET /receipt/process/all
Response:**

 JSON
[
  {
    "id": "receipt_id_1",
    "points": 123
  },

]

**Testing**
You can use tools like Postman to test the API endpoints.
