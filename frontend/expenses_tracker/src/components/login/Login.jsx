import styles from "./loginpage.module.css"
import login_image from "../../assets/loginpage/login_page_image.png"
import { IoEyeOutline, IoEyeOffOutline } from "react-icons/io5";
import { useState } from "react";


export default function LoginPage(){

    const [showPassword,setshowpassword]= useState(false);

    return (


        <>


        <div className={styles.cont}>


              {/* ----------- left image section --------- */}
            <div className={styles.image_cont}>

                <img src={login_image} alt="expenses_tracker_image" />

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

                    <h2>Welcome Back</h2>
                    <h3>Login in to your Account</h3>
                    
                </div>

                {/* --------------- input fields --------------------- */}

                <div className={styles.input_field}>

                    <form action="">

                        
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

                            <p className={styles.forgot_password_text}>forgot password</p>

                            <br/>


                            <button type="submit" className={styles.login_btn}>Login</button>

                            <p className={styles.register_text}>Don`t have an account? <span> Register</span> </p>
                       



                    </form>


                </div>


            </div>



            



        </div>
        
        
        
        </>



    );
}