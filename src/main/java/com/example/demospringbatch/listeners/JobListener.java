package com.example.demospringbatch.listeners;

import com.example.demospringbatch.helpers.Constants;
import com.example.demospringbatch.model.Person;
import com.example.demospringbatch.processor.PersonItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobListener extends JobExecutionListenerSupport {

    private static final Logger LOG = LoggerFactory.getLogger(JobListener.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JobListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOG.info("Job end.");
            jdbcTemplate.query("SELECT firstName, surname, email, phone, age FROM person",
                (rs, row) -> new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5))
            )
            .forEach(p -> LOG.info("Person from DB: " + p));
        }
    }
}
