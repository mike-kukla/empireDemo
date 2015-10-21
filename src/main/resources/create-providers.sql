create table provider ( 
        id identity primary key,
	definition varchar(255),
	providerId integer,
	providername varchar(255),
	providerstreet varchar(127),
	providercity varchar(127),
	providerstate varchar(63),
	providerzip integer,
	hrrDescription varchar(127),
	totdischarges integer,
	avgcoveredcharges double,
	avgtotpayments double,
	avgmedicarepayments double
);
 
