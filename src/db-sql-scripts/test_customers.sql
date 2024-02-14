USE `banking_system`;

-- Generate 20 more realistic customers
INSERT INTO `customers` (
    `first_name`, `last_name`, `email`, `street_address`,
    `city`, `state`, `zip_code`, `country`, `phone_number`,
    `alternate_phone_number`, `date_of_birth`, `social_security_number`,
    `account_type`, `account_number`, `account_balance`,
    `occupation`, `employer_name`, `employment_status`
)
SELECT
    first_names.first_name, -- Realistic first name
    last_names.last_name, -- Realistic last name
    CONCAT(first_names.first_name, '.', last_names.last_name, '@example.com'), -- Realistic email
    CONCAT(street_names.street_name, ' ', ROUND(RAND() * 1000), ' ', street_types.street_type), -- Realistic street address
    cities.city_name, -- Realistic city
    states.state_name, -- Realistic state
    ROUND(RAND() * 99999), -- Realistic zip code
    countries.country_name, -- Realistic country
    CONCAT('+', ROUND(RAND() * 10000000000)), -- Realistic phone number
    CONCAT('+', ROUND(RAND() * 10000000000)), -- Realistic alternate phone number
    DATE_ADD('1970-01-01', INTERVAL ROUND(RAND() * (365*50)) DAY), -- Realistic date of birth
    ROUND(RAND() * 1000000000), -- Realistic social security number
    CASE WHEN RAND() > 0.5 THEN 'Savings' ELSE 'Checking' END, -- Realistic account type
    CONCAT('ACC', ROUND(RAND() * 1000000000)), -- Realistic account number
    ROUND(RAND() * 50000 + 5000, 2), -- Random account balance between 5000 and 55000
    occupations.occupation_name, -- Realistic occupation
    employers.employer_name, -- Realistic employer name
    CASE WHEN RAND() > 0.3 THEN 'Employed' WHEN RAND() > 0.7 THEN 'Unemployed' ELSE 'Student' END -- Realistic employment status
FROM
    (SELECT 'John' AS first_name UNION SELECT 'Emma' UNION SELECT 'Michael' UNION SELECT 'Sophia' UNION SELECT 'David') AS first_names,
    (SELECT 'Smith' AS last_name UNION SELECT 'Johnson' UNION SELECT 'Williams' UNION SELECT 'Jones' UNION SELECT 'Brown') AS last_names,
    (SELECT '123 Main' AS street_name UNION SELECT '456 Oak' UNION SELECT '789 Pine' UNION SELECT '101 Maple' UNION SELECT '202 Elm') AS street_names,
    (SELECT 'St' AS street_type UNION SELECT 'Ave' UNION SELECT 'Blvd' UNION SELECT 'Rd' UNION SELECT 'Ln') AS street_types,
    (SELECT 'New York' AS city_name UNION SELECT 'Los Angeles' UNION SELECT 'Chicago' UNION SELECT 'Houston' UNION SELECT 'Phoenix') AS cities,
    (SELECT 'NY' AS state_name UNION SELECT 'CA' UNION SELECT 'IL' UNION SELECT 'TX' UNION SELECT 'AZ') AS states,
    (SELECT 'USA' AS country_name UNION SELECT 'Canada' UNION SELECT 'UK' UNION SELECT 'Australia' UNION SELECT 'Germany') AS countries,
    (SELECT 'Software Developer' AS occupation_name UNION SELECT 'Teacher' UNION SELECT 'Nurse' UNION SELECT 'Engineer' UNION SELECT 'Accountant') AS occupations,
    (SELECT 'ABC Corporation' AS employer_name UNION SELECT 'XYZ Ltd' UNION SELECT 'Acme Inc' UNION SELECT 'Global Solutions' UNION SELECT 'Tech Innovators') AS employers
    LIMIT 20;
