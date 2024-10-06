
package tn.esprit.spring_projet.Configuration;

        import lombok.extern.slf4j.Slf4j;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.aspectj.lang.JoinPoint;
        import org.aspectj.lang.annotation.After;
        import org.aspectj.lang.annotation.Aspect;
        import org.aspectj.lang.annotation.Before;
        import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class config {
    private static final Logger logger = LogManager.getLogger(config.class);
    @Before("execution(* tn.esprit.spring_projet.Services.*.*(..))")
    public  void logMethodEntry(JoinPoint joinPoint){
        logger.info("in method "+joinPoint.getSignature().getName()+":");
    }
    @After("execution(* tn.esprit.spring_projet.Services.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint){
        logger.info("out of method"+joinPoint.getSignature().getName()+":");
    }

}