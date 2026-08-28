import { Search } from "lucide-react";
import Navbar from "../Navbar/Navbar.jsx";
import styles from "./expenses.module.css";

export default function Expenses() {

    const currentYear = new Date().getFullYear();

    const years = Array.from(
        { length: 11 },
        (_, index) => currentYear - index
    );


    

    return (
        <>
            <div className={styles.cont}>

                <Navbar />

                <div className={styles.rightcont}>

                    {/* --------------- heading ------------- */}

                    <div className={styles.rhead}>

                        <h2>All Expenses</h2>

                        <button>
                            Add New
                        </button>

                    </div>

                    <br />

                    <hr className={styles.hr} />


                    {/* ------------ search bar -------------------- */}

                    <div className={styles.search}>

                        <div className={styles.searchbox}>

                            <button>
                                <Search className={styles.searchicon} />
                            </button>

                            <input
                                type="text"
                                placeholder="Search Expenses"
                            />

                        </div>


                        {/* ------------ month select ------------ */}

                        <select
                            name="month"
                            id="month"
                            className={styles.month}
                        >
                            <option value="">
                                Select Month
                            </option>

                            <option value="january">
                                January
                            </option>

                            <option value="february">
                                February
                            </option>

                            <option value="march">
                                March
                            </option>

                            <option value="april">
                                April
                            </option>

                            <option value="may">
                                May
                            </option>

                            <option value="june">
                                June
                            </option>

                            <option value="july">
                                July
                            </option>

                            <option value="august">
                                August
                            </option>

                            <option value="september">
                                September
                            </option>

                            <option value="october">
                                October
                            </option>

                            <option value="november">
                                November
                            </option>

                            <option value="december">
                                December
                            </option>
                        </select>


                        {/* ------------ year select ------------ */}

                        <select
                            name="year"
                            id="year"
                            className={styles.month}
                        >
                            <option value="">
                                Select Year
                            </option>

                            {years.map((year) => (
                                <option
                                    key={year}
                                    value={year}
                                >
                                    {year}
                                </option>
                            ))}
                        </select>

                    </div>


                    {/* ------------- table ------------- */}

                    <table >

                        <thead>

                            <th>Date</th>
                            <th>Category</th>
                            <th>Description</th>
                            <th>Amount</th>
                            <th>Actions</th>

                        </thead>
                        <tbody>

                            

                            


                        </tbody>



                    </table>

                </div>

            </div>
        </>
    );
}
