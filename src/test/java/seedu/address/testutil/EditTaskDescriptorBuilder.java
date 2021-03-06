package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditTaskDescriptor;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.Due;
import seedu.address.model.task.Module;
import seedu.address.model.task.Name;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Task;

/**
 * A utility class to help with building EditTaskDescriptor objects.
 */
public class EditTaskDescriptorBuilder {

    private EditCommand.EditTaskDescriptor descriptor;

    public EditTaskDescriptorBuilder() {
        descriptor = new EditCommand.EditTaskDescriptor();
    }

    public EditTaskDescriptorBuilder(EditCommand.EditTaskDescriptor descriptor) {
        this.descriptor = new EditCommand.EditTaskDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditTaskDescriptor} with fields containing {@code task}'s details
     */
    public EditTaskDescriptorBuilder(Task task) {
        descriptor = new EditCommand.EditTaskDescriptor();
        descriptor.setName(task.getName());
        descriptor.setModule(task.getModule());
        descriptor.setDue(task.getDue());
        descriptor.setPriority(task.getPriority());
        descriptor.setTags(task.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Module} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withPhone(String phone) {
        descriptor.setModule(new Module(phone));
        return this;
    }

    /**
     * Sets the {@code Due} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withEmail(String email) {
        descriptor.setDue(new Due(email));
        return this;
    }

    /**
     * Sets the {@code Priority} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withAddress(String address) {
        descriptor.setPriority(new Priority(address));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditTaskDescriptor}
     * that we are building.
     */
    public EditTaskDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditTaskDescriptor build() {
        return descriptor;
    }
}
