package com.alphabet.linkedin.companyms.company.messaging;


import com.alphabet.linkedin.companyms.company.dto.ReviewMessage;
import com.alphabet.linkedin.companyms.company.ComapnyService;
import com.alphabet.linkedin.companyms.company.external.Review;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This particular class is going to have all the logic.
 */
@Service
public class ReviewMessageConsumer {

    @Autowired
    private ComapnyService companyService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * The sendMessage is responsible for listening and consuming a message from,
     * a particular RabbitMQ Queue.
     */

    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage){
        companyService.updateCompanyRating(reviewMessage);
    }
}
