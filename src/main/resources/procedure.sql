CREATE PROCEDURE Sp_ComputarPartida(IN p_matchID INT)
BEGIN

    DECLARE v_teamHouseID INT;
    DECLARE v_teamVisitorID INT;
    DECLARE v_goalHouse INT;
    DECLARE v_goalVisitor INT;

    SELECT teamHouseID, teamVisitorID, goalHouse, goalVisitor
    INTO v_teamHouseID, v_teamVisitorID, v_goalHouse, v_goalVisitor
    FROM Match_Table
    WHERE matchID = p_matchID;

    UPDATE Team
    SET matchesPlayed = matchesPlayed + 1
    WHERE teamID IN (v_teamHouseID, v_teamVisitorID);

    IF v_goalHouse > v_goalVisitor THEN

        UPDATE Team
        SET points = points + 3
        WHERE teamID = v_teamHouseID;

    ELSEIF v_goalVisitor > v_goalHouse THEN

        UPDATE Team
        SET points = points + 3
        WHERE teamID = v_teamVisitorID;

    ELSE

        UPDATE Team
        SET points = points + 1
        WHERE teamID IN (v_teamHouseID, v_teamVisitorID);

    END IF;

END;