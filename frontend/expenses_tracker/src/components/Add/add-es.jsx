import Navbar from "../Navbar/Navbar.jsx";
import styles from "./add-es.module.css";
import add_image from "../../assets/dashbaord_images/add_expenses.png";
import { useState } from "react";

export default function Add() {
  const [category, setcategory] = useState("");
  const [amount, setamount] = useState("");
  const [description, setdescription] = useState("");
  const [date, setdate] = useState(
    new Date().toISOString().split("T")[0]
  );

  const handlesave = (e) => {
    e.preventDefault();

    console.log(category);
    console.log(amount);
    console.log(description);
    console.log(date);

    // Reset form
    setamount("");
    setcategory("");
    setdescription("");

    // Reset date to today
    setdate(new Date().toISOString().split("T")[0]);
  };

  return (
    <>
      <div className={styles.cont}>
        <Navbar />

        <div className={styles.rightcont}>
          <div className={styles.rhead}>
            <img src={add_image} alt="add_image" />
            <h2>Add Expenses</h2>
          </div>

          <form onSubmit={handlesave}>
            <div className={styles.catbox}>

              {/* Category */}
              <div className={styles.formin}>
                <label htmlFor="category">
                  Category <span>*</span>
                </label>
                <br />

                <select
                  name="category"
                  id="category"
                  value={category}
                  required
                  onChange={(e) => setcategory(e.target.value)}
                >
                  <option value="">Select Category</option>
                  <option value="Food">Food</option>
                  <option value="Entertainment">Entertainment</option>
                  <option value="Clothes">Clothes</option>
                  <option value="Groceries">Groceries</option>
                  <option value="Petrol">Petrol</option>
                  <option value="Vehicle">Vehicle</option>
                  <option value="Loans">Loans</option>
                  <option value="Others">Others</option>
                </select>
              </div>

              {/* Amount */}
              <div className={styles.formin}>
                <label htmlFor="amount">
                  Amount <span>*</span>
                </label>
                <br />

                <input
                  type="number"
                  required
                  placeholder="Enter the Amount"
                  id="amount"
                  value={amount}
                  onChange={(e) => setamount(e.target.value)}
                />
              </div>

            </div>

            {/* Description */}
            <div className={styles.desc}>
              <label htmlFor="desc">
                Description <span>*</span>
              </label>
              <br />

              <textarea
                name="desc"
                id="desc"
                rows={6}
                required
                value={description}
                onChange={(e) => setdescription(e.target.value)}
              />
            </div>

            {/* Date */}
            <div className={styles.date}>
              <label htmlFor="date">
                Date <span>*</span>
              </label>
              <br />

              <input
                type="date"
                id="date"
                required
                value={date}
                onChange={(e) => setdate(e.target.value)}
              />
            </div>

            {/* Save */}
            <button type="submit">Save</button>
          </form>
        </div>
      </div>
    </>
  );
}
