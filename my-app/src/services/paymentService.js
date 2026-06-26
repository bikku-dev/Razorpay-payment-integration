import axios from "axios";

export const createOrder = async () => {
  const response = await axios.post(
    "http://localhost:8080/payment/create-order"
  );

  return response.data;
};