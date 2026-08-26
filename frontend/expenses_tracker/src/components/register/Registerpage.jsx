import styles from "./registerpage.module.css"
import register_image from "../../assets/loginpage/register_page_image.png"
import { useState } from "react";
import { IoEyeOutline, IoEyeOffOutline } from "react-icons/io5";
import {Link} from "react-router-dom";


export default function RegisterPage(){

    const [showPassword,setshowpassword]=useState(false)
    
    return (

        <>

      <div className={styles.cont}>


              {/* ----------- left image section --------- */}
            <div className={styles.image_cont}>

                <img src={register_image} alt="expenses_tracker_image" />

                   {/* ----------- image text ------------------- */}
                <div className={styles.image_text}>
                    <h2>Track Your Expenses</h2>
                    <h3>Manage your daily expenses and save your money </h3>
                </div>

            </div>


            {/* ----------- right side content ------------------ */}

            <div className={styles.right_content}>



                    {/* ----------- right head -------------- */}
                <div className={styles.right_head}>

                    <h2>Create an Account</h2>
                    <h3>Create your account to get started</h3>
                    
                </div>

                {/* --------------- input fields --------------------- */}

                <div className={styles.input_field}>

                    <form action="">


                             <div className={styles.form_email}>
                                <label htmlFor="name">Name</label><br/>
                                <input type="name" id="name" autoComplete="name"/>
                            </div>

                             <br/>

                        
                            <div className={styles.form_email}>
                                <label htmlFor="email">Email</label><br/>
                                <input type="email" id="email" autoComplete="email"/>
                            </div>

                               <br/>
                            <div className={styles.form_password}>

                                <label htmlFor="password">Password</label><br/>
                                <input type={showPassword ? "text": "password"} id="password" autoComplete="password"/>
                                <button type="button" onClick={()=>setshowpassword(!showPassword)} className={styles.eyebutton}>{showPassword ? <IoEyeOffOutline/>:<IoEyeOutline/> } </button>
                            </div>

                            <br/>

                            <div className={styles.form_password}>

                                <label htmlFor="repassword">Confirm Password</label><br/>
                                <input type={showPassword ? "text": "password"} id="repassword" autoComplete="repassword"/>
                                <button type="button" onClick={()=>setshowpassword(!showPassword)} className={styles.eyebutton}>{showPassword ? <IoEyeOffOutline/>:<IoEyeOutline/> } </button>
                            </div>




                            <br/>
                            <br/>


                            <button type="submit" className={styles.login_btn}>Register</button>

                            <p className={styles.register_text}>Already have an account? <span> <Link to="/">Login</Link></span> </p>
                       

                    </form>
                </div>

            </div>

        </div>
        
        
        
        </>




    );
}