# ApartmentHub App

A Hibernate-based Apartment Management System for managing a gated community — including flats, residents, visitors, complaints, announcements, amenities, parking, and maintenance.

## Author

**M Uday Kumar Reddy**
GitHub: [https://github.com/ukr16/ApartmentHub](https://github.com/ukr16/ApartmentHub)

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 26 |
| ORM | Hibernate 6 |
| Database | PostgreSQL |
| Build Tool | Maven |
| Containerization | Docker |

---

## Project Structure

```
ApartmentHub/
├── src/main/java/org/example/
│    ├── entity/
│    │    ├── Apartment.java
│    │    ├── Flats.java
│    │    ├── Amenity.java
│    │    ├── Resident.java
│    │    ├── Parking.java
│    │    ├── Visitor.java
│    │    ├── Compliant.java
│    │    ├── Announcement.java
│    │    └── Maintenance.java
│    ├── dao/
│    │    ├── ApartmentDAO.java
│    │    ├── FlatsDAO.java
│    │    ├── AmenityDAO.java
│    │    ├── ResidentDAO.java
│    │    ├── ParkingDAO.java
│    │    ├── VisitorDAO.java
│    │    ├── CompliantDAO.java
│    │    ├── AnnouncementDAO.java
│    │    └── MaintenanceDAO.java
│    ├── dao/impl/
│    │    ├── ApartmentDAOImpl.java
│    │    ├── FlatsDAOImpl.java
│    │    ├── AmenityDAOImpl.java
│    │    ├── ResidentDAOImpl.java
│    │    ├── ParkingDAOImpl.java
│    │    ├── VisitorDAOImpl.java
│    │    ├── CompliantDAOImpl.java
│    │    ├── AnnouncementDAOImpl.java
│    │    └── MaintenanceDAOImpl.java
│    ├── util/
│    │    └── HibernateUtil.java
│    └── Main.java
├── src/main/resources/
│    └── hibernate.cfg.xml
├── Dockerfile
└── pom.xml
```

---

## Entities

| Entity | Description |
|---|---|
| `Apartment` | The main building/complex |
| `Flats` | Individual flat units |
| `Amenity` | Gym, Pool, Party-Hall etc. |
| `Resident` | Owner or tenant living in a flat |
| `Parking` | Parking slots assigned to residents |
| `Visitor` | Guest/delivery/househelp entry management |
| `Compliant` | Complaints raised by residents |
| `Announcement` | Notices posted by admin |
| `Maintenance` | Monthly maintenance management |

---

## Getting Started

### Prerequisites

- Java 26
- PostgreSQL 18
- Maven
- Docker (optional)

### Setup

1. Clone the repository:
```bash
git clone https://github.com/ukr16/ApartmentHub.git
cd ApartmentHub
```

2. Create a PostgreSQL database:
```sql
CREATE DATABASE apartmenthub;
```

3. Update `hibernate.cfg.xml` with your DB credentials:
```xml
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/apartmenthub</property>
<property name="hibernate.connection.username">postgres</property>
<property name="hibernate.connection.password">your_password</property>
```

4. Build and run:
```bash
mvn clean package
java -jar target/ApartmentHub-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

## Docker

Build and run using Docker:

```bash
mvn clean package
docker build -t apartmenthub .
docker run --add-host=host.docker.internal:host-gateway apartmenthub
```

---

## Features

- CRUD operations for all entities
- Query flats by status (VACANT/OCCUPIED), floor, block
- Track active visitors (entry/exit time)
- Manage resident complaints with status tracking (OPEN/IN_PROGRESS/RESOLVED)
- Maintenance due tracking (PAID/UNPAID/OVERDUE)
- Amenity management with availability and capacity
- Parking slot management (TWO_WHEELER/THREE_WHEELER/FOUR_WHEELER)

---

## License

This project is for learning purposes.
