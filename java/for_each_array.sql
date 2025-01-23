DO
$$
declare
	ir varchar;
    irs varchar[] := array[
'mns',
'fszn',
'population_register',
'zags',
'mvd',
'nsi',
'mns_001',
'mns_002',
'zx'];
BEGIN
    FOREACH ir IN array irs
    LOOP
        EXECUTE format('ALTER TABLE %I_system.schema_current_checks OWNER TO "aispi-information-resource-manager-service_user";', ir);
    END LOOP;
END;
$$
LANGUAGE plpgsql;
