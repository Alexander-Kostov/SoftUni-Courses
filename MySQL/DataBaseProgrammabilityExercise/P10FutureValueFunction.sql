DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(17,4), yearly_interest_rate DOUBLE(17,4), number_of_years INT)
RETURNS DECIMAL(17,4) 
DETERMINISTIC
BEGIN
DECLARE future_sum DECIMAL(17,4);
SET future_sum := initial_sum * POW(1 + yearly_interest_rate, number_of_years);
RETURN future_sum;
END$$