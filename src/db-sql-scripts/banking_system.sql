CREATE
DATABASE IF NOT EXISTS `banking_system`;
USE
`banking_system`;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
                             `id`                     BIGINT NOT NULL AUTO_INCREMENT,
                             `first_name`             VARCHAR(255) DEFAULT NULL,
                             `last_name`              VARCHAR(255) DEFAULT NULL,
                             `email`                  VARCHAR(255) DEFAULT NULL,
                             `street_address`         VARCHAR(255) DEFAULT NULL,
                             `city`                   VARCHAR(255) DEFAULT NULL,
                             `state`                  VARCHAR(255) DEFAULT NULL,
                             `zip_code`               VARCHAR(20)  DEFAULT NULL,
                             `country`                VARCHAR(255) DEFAULT NULL,
                             `phone_number`           VARCHAR(20)  DEFAULT NULL,
                             `alternate_phone_number` VARCHAR(20)  DEFAULT NULL,
                             `date_of_birth`          DATE         DEFAULT NULL,
                             `social_security_number` VARCHAR(20)  DEFAULT NULL,
                             `account_type`           VARCHAR(255) DEFAULT NULL,
                             `account_number`         VARCHAR(255) DEFAULT NULL,
                             `account_balance`        DECIMAL(19, 2) DEFAULT NULL,
                             `occupation`             VARCHAR(255) DEFAULT NULL,
                             `employer_name`          VARCHAR(255) DEFAULT NULL,
                             `employment_status`      VARCHAR(255) DEFAULT NULL,
                             `created_date`           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             `last_modified_date`     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             `created_by`             VARCHAR(255) DEFAULT NULL,
                             `last_modified_by`       VARCHAR(255) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;

CREATE TABLE `transactions` (
                                `id`                         BIGINT NOT NULL AUTO_INCREMENT,
                                `customer_id`                BIGINT       DEFAULT NULL,
                                `amount` DOUBLE DEFAULT NULL,
                                `type`                       VARCHAR(255) DEFAULT NULL,
                                `transaction_id`             VARCHAR(255) DEFAULT NULL,
                                `timestamp`                  DATETIME     DEFAULT NULL,
                                `description`                VARCHAR(255) DEFAULT NULL,
                                `currency_code`              VARCHAR(10)  DEFAULT NULL,
                                `status`                     VARCHAR(255) DEFAULT NULL,
                                `method`                     VARCHAR(255) DEFAULT NULL,
                                `reference_number`           VARCHAR(255) DEFAULT NULL,
                                `source_account_number`      VARCHAR(255) DEFAULT NULL,
                                `destination_account_number` VARCHAR(255) DEFAULT NULL,
                                `transaction_fee` DOUBLE DEFAULT NULL,
                                `balance_after_transaction` DOUBLE DEFAULT NULL,
                                `authorized_by`              VARCHAR(255) DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

