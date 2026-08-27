import styles from "./Navbar.module.css";
import logo from "../../assets/dashbaord_images/pie_logo_images.png";

import {
  LayoutDashboard,
  Plus,
  Pencil,
  Tags,
  User,
  LogOut,
} from "lucide-react";

import { NavLink } from "react-router-dom";

export default function Navbar() {

  const navItems = [
    {
      name: "Dashboard",
      icon: LayoutDashboard,
      path: "/dashboard",
    },
    {
      name: "Add Expenses",
      icon: Plus,
      path: "/add-expenses",
    },
    {
      name: "Edit Expenses",
      icon: Pencil,
      path: "/edit-expenses",
    },
    {
      name: "Categories",
      icon: Tags,
      path: "/categories",
    },
    {
      name: "Profile",
      icon: User,
      path: "/profile",
    },
  ];

  return (
    <div className={styles.cont}>

      <div className={styles.head}>
        <img src={logo} alt="logo" />
        <h2>Expense Tracker</h2>
      </div>

      <nav className={styles.navbar}>

        {navItems.map((item) => {

          const Icon = item.icon;

          return (
            <NavLink
              key={item.name}
              to={item.path}
              className={({ isActive }) =>
                `${styles.navicon} ${
                  isActive ? styles.active : ""
                }`
              }
            >
              <Icon
                className={styles.icon}
                size={30}
              />

              <p>{item.name}</p>
            </NavLink>
          );

        })}

        <div className={styles.logout}>
          <LogOut
            className={styles.icon}
            size={30}
          />
          <p>Logout</p>
        </div>

      </nav>

    </div>
  );
}
