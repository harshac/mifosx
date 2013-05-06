INSERT INTO c_configuration (name,enabled) VALUES ('amazon-S3',0);


CREATE TABLE IF NOT EXISTS m_external_services (
	name VARCHAR(150) NOT NULL,
	value VARCHAR(250),
	UNIQUE(name) 
);

INSERT INTO m_external_services (name) VALUES ('s3_cdn_url');
INSERT INTO m_external_services (name) VALUES ('s3_bucket_name');
INSERT INTO m_external_services (name) VALUES ('s3_access_key');
INSERT INTO m_external_services (name) VALUES ('s3_secret_key');

ALTER TABLE m_document ADD COLUMN storage_type varchar(50);
