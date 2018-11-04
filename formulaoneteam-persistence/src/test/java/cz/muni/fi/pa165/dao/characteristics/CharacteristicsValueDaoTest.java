package cz.muni.fi.pa165.dao.characteristics;

import cz.muni.fi.pa165.AppContextConfig;
import cz.muni.fi.pa165.entity.CharacteristicsType;
import cz.muni.fi.pa165.entity.CharacteristicsValue;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.AssertJUnit;

import javax.inject.Inject;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Adel Chakouri
 */

@ContextConfiguration(classes= AppContextConfig.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class CharacteristicsValueDaoTest extends AbstractTestNGSpringContextTests {

    @Inject
    private CharacteristicsValueDao characteristicsValueDao;

    @Test
    public void addCharacteristics_withValidData_isPersisted() {
        CharacteristicsType type = CharacteristicsType.AGGRESIVITY;
        CharacteristicsValue characteristicsValue = createCharacteristics(type);

        //Then
        characteristicsValueDao.add(characteristicsValue);

        //That
        AssertJUnit.assertNotNull(characteristicsValueDao.findById(characteristicsValue.getId()));
    }

    @Test
    public void deleteCharacteristics_withValidData_isPersisted() {

        CharacteristicsType type = CharacteristicsType.AGGRESIVITY;
        CharacteristicsValue characteristicsValue = createCharacteristics(type);

        characteristicsValueDao.add(characteristicsValue);
        characteristicsValueDao.delete(characteristicsValue);

        List<CharacteristicsValue> result = (List<CharacteristicsValue>) characteristicsValueDao.findCharacteristicValuesByType(type);
        assertEquals(0, result.size());

    }

    @Test
    public void updateCharacteristics(){

        CharacteristicsType oldType = CharacteristicsType.AGGRESIVITY;
        CharacteristicsType newType = CharacteristicsType.PATIENCE;

        CharacteristicsValue characteristicsValue = createCharacteristics(oldType);

        characteristicsValueDao.add(characteristicsValue);

        characteristicsValue.setType(newType);

        List<CharacteristicsValue> oldCharacteristics =characteristicsValueDao.findCharacteristicValuesByType(oldType);
        List<CharacteristicsValue> newCharacteristics =characteristicsValueDao.findCharacteristicValuesByType(newType);

        assertEquals(0, oldCharacteristics.size());
        assertEquals(1, newCharacteristics.size());

    }



    private CharacteristicsValue createCharacteristics(CharacteristicsType Type){
        CharacteristicsValue characteristicsValue = new CharacteristicsValue();

        characteristicsValue.setValue(100.0);
        characteristicsValue.setType(Type);

        return characteristicsValue;
    }
}
