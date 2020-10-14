package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.main.DeleteBudgetCommand;
import seedu.address.logic.commands.main.OpenBudgetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expenditure.Price;
import seedu.address.model.tag.Tag;
import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.budgetindex.BudgetIndexManager;
import seedu.address.state.expenditureindex.ExpenditureIndex;
import seedu.address.state.expenditureindex.ExpenditureIndexManager;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer. \n%1$s";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses {@code oneBasedIndex} into a {@code ExpenditureIndex} and returns it.
     * Leading and trailing whitespaces will be trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static ExpenditureIndex parseExpenditureIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(String.format(MESSAGE_INVALID_INDEX, DeleteBudgetCommand.MESSAGE_USAGE));
        }
        return new ExpenditureIndexManager(Integer.parseInt(trimmedIndex) - 1);
    }


    /**
     * Parses {@code oneBasedIndex} into a {@code BudgetIndex} and returns it.
     * Leading and trailing whitespaces will be trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static BudgetIndex parseBudgetIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(String.format(MESSAGE_INVALID_INDEX, OpenBudgetCommand.MESSAGE_USAGE));
        }
        return new BudgetIndexManager(Integer.parseInt(trimmedIndex) - 1);
    }

    /**
     * Parses a {@code String expenditureName} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static seedu.address.model.expenditure.Name parseExpenditureName(String expenditureName)
            throws ParseException {
        requireNonNull(expenditureName);
        String trimmedName = expenditureName.trim();
        if (!seedu.address.model.expenditure.Name.isValidName(trimmedName)) {
            throw new ParseException(seedu.address.model.expenditure.Name.MESSAGE_CONSTRAINTS);
        }
        return new seedu.address.model.expenditure.Name(trimmedName);
    }

    /**
     * Parses a {@code String price} into a {@code Price}.
     * Leading and trailing whitespaces will be trimmed.
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Price parsePrice(String price) throws ParseException {
        requireNonNull(price);
        String trimmedPrice = price.trim();
        if (!Price.isValid(trimmedPrice)) {
            throw new ParseException(Price.MESSAGE_CONSTRAINTS);
        }
        return new Price(trimmedPrice);
    }

    /**
     * Parses a {@code String budgetName} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static seedu.address.model.budget.Name parseBudgetName(String budgetName) throws ParseException {
        requireNonNull(budgetName);
        String trimmedName = budgetName.trim();
        if (!seedu.address.model.budget.Name.isValid(trimmedName)) {
            throw new ParseException(seedu.address.model.budget.Name.MESSAGE_CONSTRAINTS);
        }
        return new seedu.address.model.budget.Name(trimmedName);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValid(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
}
